package com.shenawynkov.weatherApp.utils

import com.google.gson.Gson
import com.shenawynkov.weatherApp.data.ErrorResponse
import retrofit2.HttpException
import java.nio.charset.StandardCharsets

object HelperFunc {
     fun convertErrorBody(throwable: HttpException): ErrorResponse? {
         return try {
             throwable.response()?.errorBody()?.source()?.let {
                 val moshiAdapter = Gson().fromJson<ErrorResponse>(
                     it.readString(StandardCharsets.UTF_8),
                     ErrorResponse::class.java
                 )
                 moshiAdapter
             }
         } catch (exception: Exception) {
             null
         }
     }
}