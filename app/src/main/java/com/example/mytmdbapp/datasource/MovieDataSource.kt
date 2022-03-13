package com.example.mytmdbapp.datasource

import com.example.mytmdbapp.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieDataSource {
    suspend fun getPopularMovies(): Flow<List<Movie>>
}