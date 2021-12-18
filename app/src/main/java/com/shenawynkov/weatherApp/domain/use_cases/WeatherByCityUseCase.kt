package com.shenawynkov.weatherApp.domain.use_cases

import com.shenawynkov.weatherApp.common.Resource
import com.shenawynkov.weatherApp.data.ErrorResponse
import com.shenawynkov.weatherApp.data.WeatherRepoImpl
import com.shenawynkov.weatherApp.domain.data.model.WeatherResponse
import com.shenawynkov.weatherApp.domain.repo.WeatherRepo
import com.shenawynkov.weatherApp.utils.HelperFunc
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class WeatherByCityUseCase @Inject constructor(private val repo: WeatherRepo) {
    operator fun invoke(city: String): Flow<Resource<WeatherResponse>> = flow {
        try {
            //emit loading until receiving data
            emit(Resource.Loading<WeatherResponse>())
            //emit  data
            emit(Resource.Success(repo.getWeatherByCity(city)))
        } catch (e: HttpException) {
            val error = HelperFunc.convertErrorBody(e)
            emit(
                Resource.Error<WeatherResponse>(
                    error?.message ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<WeatherResponse>("Couldn't reach server. Check your internet connection."))
        }
    }
}