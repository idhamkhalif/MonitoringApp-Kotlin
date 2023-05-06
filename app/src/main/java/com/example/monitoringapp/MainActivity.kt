package com.example.monitoringapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val api by lazy { ApiRetrovit().endpoint }
    private lateinit var sensorAdapter: SensorAdapter
    private lateinit var listsensor : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupList()
    }

    override fun onStart() {
        super.onStart()
        getSensor()
    }

    private fun setupList()
    {
        listsensor = findViewById(R.id.list_sensor)
        sensorAdapter = SensorAdapter(arrayListOf())
        listsensor.adapter = sensorAdapter
    }

    private fun getSensor()
    {
        api.data().enqueue(object: Callback<MonitoringModel>{ //alt + enter cari callback retrofit2
            override fun onResponse(
                call: Call<MonitoringModel>,
                response: Response<MonitoringModel>
            ) {
                if(response.isSuccessful)
                {
                    val listdata = response.body()!!.sensor
                    sensorAdapter.setData(listdata)

                    listdata.forEach {
                        Log.e("MainActivity","id ${it.id}")
                        Log.e("MainActivity","Humidity ${it.humidity}")
                        Log.e("MainActivity","Temperature ${it.temperature}")
                        Log.e("MainActivity","Light ${it.light}")
                    }

                }

            }

            override fun onFailure(call: Call<MonitoringModel>, t: Throwable) {
                Log.e("MainActivity",t.toString())
            }

        })
    }
}