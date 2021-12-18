package com.shenawynkov.weatherApp.di

import com.shenawynkov.weatherApp.data.WeatherRepoImpl
import com.shenawynkov.weatherApp.domain.ApiService
import com.shenawynkov.weatherApp.domain.repo.WeatherRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {

    @Provides
    @Singleton
    fun provideHomeRepository(apiService: ApiService): WeatherRepo {
        return WeatherRepoImpl(apiService)
    }

}