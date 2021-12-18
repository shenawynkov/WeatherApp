package com.shenawynkov.weatherApp.domain.repo

import com.shenawynkov.weatherApp.domain.data.model.WeatherResponse

interface WeatherRepo {
     suspend fun getWeatherByLocation(lat: String, lon: String):WeatherResponse
     suspend fun getWeatherByCity(city: String):WeatherResponse
}