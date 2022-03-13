package com.example.mytmdbapp.di

import com.example.mytmdbapp.datasource.MovieDataSource
import com.example.mytmdbapp.datasource.MovieNetworkDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class NetworkDataSourceModule

@Module
abstract class DataSourceModule {

    @Singleton
    @Binds
    @NetworkDataSourceModule
    abstract fun bindMovieNetworkDataSource(impl: MovieNetworkDataSource): MovieDataSource
}