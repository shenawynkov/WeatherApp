package com.shenawynkov.weatherApp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shenawynkov.weatherApp.data.WeatherRepoImpl
import com.shenawynkov.weatherApp.domain.use_cases.WeatherByCityUseCase
import com.shenawynkov.weatherApp.domain.use_cases.WeatherByLocationUseCase
import javax.inject.Inject

class HomeViewModelFactory
@Inject constructor(private val weatherByLocationUseCase: WeatherByLocationUseCase, private val weatherByCityUseCase: WeatherByCityUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(
            weatherByLocationUseCase,weatherByCityUseCase
        ) as T
    }


}