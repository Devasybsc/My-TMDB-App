package com.example.mytmdbapp.di

import com.example.mytmdbapp.network.ApiConstants
import com.example.mytmdbapp.network.MoviesApiService
import com.example.mytmdbapp.network.interceptors.AuthenticationInterceptor
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideApi(builder: Retrofit.Builder): MoviesApiService {
        return builder
            .build()
            .create(MoviesApiService::class.java)
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .baseUrl(ApiConstants.BASE_URL)
            .client(okHttpClient)
    }

    @Provides
    fun provideOkHttpClient(
        authenticationInterceptor: AuthenticationInterceptor
    ): OkHttpClient {
        val loggingInterceptor: HttpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(authenticationInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }
}