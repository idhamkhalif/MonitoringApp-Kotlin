package com.example.monitoringapp

import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("data.php")
    fun data() : Call<MonitoringModel>
}