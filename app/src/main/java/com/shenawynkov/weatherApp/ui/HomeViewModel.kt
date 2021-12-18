package com.shenawynkov.weatherApp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shenawynkov.weatherApp.common.Resource
import com.shenawynkov.weatherApp.data.WeatherRepoImpl
import com.shenawynkov.weatherApp.domain.data.model.WeatherResponse
import com.shenawynkov.weatherApp.domain.use_cases.WeatherByCityUseCase
import com.shenawynkov.weatherApp.domain.use_cases.WeatherByLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val weatherByLocationUseCase: WeatherByLocationUseCase,val weatherByCityUseCase: WeatherByCityUseCase) : ViewModel() {
    val weather = MutableLiveData<WeatherResponse>()
    val loading=MutableLiveData(false)
    val errorMessage=MutableLiveData<String>()
    fun getWeatherByLocation(lat: String, lon: String) {
        weatherByLocationUseCase(lat, lon).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    loading.value=false
                    weather.value= result.data

                }
                is Resource.Error -> {
                    loading.value=false
                    errorMessage.value=result.message

                }
                is Resource.Loading -> {
                    loading.value=true

                }
            }


        }.launchIn(viewModelScope)

    }
    fun getWeatherByCity(city:String) {

        weatherByCityUseCase(city).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    loading.value=false
                    weather.value= result.data

                }
                is Resource.Error -> {
                    loading.value=false
                    errorMessage.value=result.message

                }
                is Resource.Loading -> {
                    loading.value=true

                }
            }


        }.launchIn(viewModelScope)
    }


}