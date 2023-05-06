package com.example.monitoringapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import okhttp3.internal.notify


class SensorAdapter(val sensor : ArrayList<MonitoringModel.Data>):RecyclerView.Adapter<SensorAdapter.ViewHolder>()
{
    override fun getItemCount() = sensor.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_sensor,parent,false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val data = sensor[position]
        holder.textId.text = "Id : " + data.id
        holder.textHumidity.text = "Humidity : " + data.humidity
        holder.textTemperature.text = "Temperature : " + data.temperature
        holder.textLight.text = "Light : " + data.light
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)
    {
        val textId = view.findViewById<TextView>(R.id.text_id)
        val textHumidity = view.findViewById<TextView>(R.id.text_humidity)
        val textTemperature = view.findViewById<TextView>(R.id.text_temperature)
        val textLight = view.findViewById<TextView>(R.id.text_light)

    }

    public fun setData(data : List<MonitoringModel.Data>){
        sensor.clear()
        sensor.addAll(data)
        notifyDataSetChanged()
    }

}