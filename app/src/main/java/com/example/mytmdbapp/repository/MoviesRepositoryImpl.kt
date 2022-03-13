package com.example.mytmdbapp.repository

import com.example.mytmdbapp.model.Movie
import com.example.mytmdbapp.datasource.MovieNetworkDataSource
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

/**
 * Combines local and remote data sources to return movie data
 * Source of truth is the DB cache data
 */
class MoviesRepositoryImpl @Inject constructor(
    private val movieNetworkDataSource: MovieNetworkDataSource,
) : MoviesRepository {


    override suspend fun getMostPopularMovies(): Flow<List<Movie>> {
        return movieNetworkDataSource.getPopularMovies()
    }

    override suspend fun getMovieById(movieId: Int): Flow<Movie?> {
        TODO("Not yet implemented")
    }
}