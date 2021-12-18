package com.shenawynkov.weatherApp.data

import com.shenawynkov.weatherApp.domain.ApiService
import com.shenawynkov.weatherApp.domain.repo.WeatherRepo

class WeatherRepoImpl(private val apiService: ApiService) :WeatherRepo {
    override suspend fun getWeatherByLocation(lat:String, lon:String)=apiService.getWeatherByLocation(lat,lon)
    override suspend fun getWeatherByCity(city:String)=apiService.getWeatherByCityName(city)

}   
