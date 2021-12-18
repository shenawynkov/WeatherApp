package com.shenawynkov.weatherApp.domain

import com.shenawynkov.weatherApp.BuildConfig
import com.shenawynkov.weatherApp.common.Constants.weather
import com.shenawynkov.weatherApp.domain.data.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(weather)
    suspend fun getWeatherByCityName(@Query("q") city:String,
                                     @Query("appid") apikey:String=BuildConfig.api_key): WeatherResponse
    @GET(weather)
    suspend fun getWeatherByLocation(@Query("lat") lat:String,
                                     @Query("lon") lon:String,
                                     @Query("appid") apikey:String=BuildConfig.api_key): WeatherResponse
}