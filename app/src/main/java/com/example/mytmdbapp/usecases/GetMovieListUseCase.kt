package com.example.mytmdbapp.usecases

import com.example.mytmdbapp.model.Movie
import com.example.mytmdbapp.repository.MoviesRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetMovieListUseCase @Inject constructor(
    private val popularMoviesRepository: MoviesRepository
) {

    suspend fun getPopularMovies(): Flow<List<Movie>> {
        return popularMoviesRepository.getMostPopularMovies()
    }

}