package com.example.home_6_android_3.hilt.di

import com.example.home_6_android_3.hilt.data.remote.api.PhotoApiService
import com.example.home_6_android_3.hilt.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Provides
    @Singleton
    fun providePostApiService(): PhotoApiService {
        return retrofitClient.photoApiService
    }
}