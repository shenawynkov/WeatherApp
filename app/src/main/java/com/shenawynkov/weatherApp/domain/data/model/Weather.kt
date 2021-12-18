package com.shenawynkov.weatherApp.domain.data.model

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)