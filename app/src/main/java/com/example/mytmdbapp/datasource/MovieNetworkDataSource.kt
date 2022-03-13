package com.example.mytmdbapp.datasource

import android.content.Context
import com.example.mytmdbapp.model.Movie
import com.example.mytmdbapp.network.ApiConstants
import com.example.mytmdbapp.network.MoviesApiService
import com.example.mytmdbapp.network.NetworkConnectivityManager
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow

/**
 * To Manage Movies Apis
 */
class MovieNetworkDataSource @Inject constructor(
    private val moviesApiService: MoviesApiService,
    private val context: Context
) : MovieDataSource {

    /**
     * Load popular movies from the API
     */
    override suspend fun getPopularMovies(): Flow<List<Movie>> {
        return if (NetworkConnectivityManager.isNetworkConnected(context)) {
            flow {
                try {
                    val resp = moviesApiService.getPopularMovies().movieList.map {
                        it.posterPath =
                            ApiConstants.thumbUrl + ApiConstants.thumbSize185 + it.posterPath
                        it
                    }
                    emit(resp)

                } catch (e: Exception) {
                    throw e
                }
            }
        } else {
            emptyFlow()
        }
    }
}