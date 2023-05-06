package com.example.monitoringapp

data class MonitoringModel (val sensor: List<Data>){
    data class Data (val id:String?, val temperature:String?, val humidity:String?, val light:String?)
}