package com.example.monitoringapp

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRetrovit {
   val endpoint : ApiEndpoint
   get() {
       val interceptor = HttpLoggingInterceptor()
       interceptor.level = HttpLoggingInterceptor.Level.BODY

       val client = OkHttpClient.Builder()
           .addInterceptor(interceptor)
           .build()

       val retrofit = Retrofit.Builder()
           .baseUrl("https://icweding.000webhostapp.com/monitoring/")
           .addConverterFactory(GsonConverterFactory.create())
           .build()
       return retrofit.create(ApiEndpoint::class.java)
   }
}