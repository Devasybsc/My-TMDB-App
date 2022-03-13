package com.example.mytmdbapp.repository

import com.example.mytmdbapp.model.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun getMostPopularMovies(): Flow<List<Movie>>
    suspend fun getMovieById(movieId: Int): Flow<Movie?>
}


