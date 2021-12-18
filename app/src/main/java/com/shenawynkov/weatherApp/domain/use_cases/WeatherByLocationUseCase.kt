package com.shenawynkov.weatherApp.domain.use_cases

import com.shenawynkov.weatherApp.common.Resource
import com.shenawynkov.weatherApp.data.WeatherRepoImpl
import com.shenawynkov.weatherApp.domain.data.model.WeatherResponse
import com.shenawynkov.weatherApp.domain.repo.WeatherRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class WeatherByLocationUseCase @Inject constructor(private val repo: WeatherRepo) {
    operator fun invoke(lat: String, lon: String): Flow<Resource<WeatherResponse>> = flow {
        try {
            //emit loading until receiving data
            emit(Resource.Loading<WeatherResponse>())
            //emit  data
            emit(Resource.Success(repo.getWeatherByLocation(lat, lon)))
        } catch (e: HttpException) {
            emit(
                Resource.Error<WeatherResponse>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<WeatherResponse>("Couldn't reach server. Check your internet connection."))
        }
    }
}