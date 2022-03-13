package com.example.mytmdbapp.di

import com.example.mytmdbapp.repository.MoviesRepository
import com.example.mytmdbapp.repository.MoviesRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class MoviesModule {
    @Singleton
    @Binds
    abstract fun bindMovieLocalDataSource(impl: MoviesRepositoryImpl): MoviesRepository

}