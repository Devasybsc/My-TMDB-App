package com.example.mytmdbapp.usecases

import com.example.mytmdbapp.model.Movie
import com.example.mytmdbapp.repository.MoviesRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetMovieDetailUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {

//    suspend fun getMovieDetail(movieId: Int): Flow<Movie?> {
//        return moviesRepository.getMovieById(movieId)
//    }

//    suspend fun toggleFavorite(movieId: Int) {
//        moviesRepository.toggleFavorite(movieId)
//    }
//
//    suspend fun getMovieCast(movieId: Int): Flow<List<Role?>> {
//        return moviesRepository.getMovieCast(movieId)
//    }
//
//    suspend fun getMovieProviders(movieId: Int): Flow<List<Provider?>> {
//        return moviesRepository.getMovieProviders(movieId)
//    }
}