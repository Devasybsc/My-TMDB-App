package com.example.mytmdbapp.network

import com.example.mytmdbapp.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiService {

    @GET(ApiConstants.GET_POPULAR)
    suspend fun getPopularMovies(
        @Query("include_adult") adult: Boolean = false,
        @Query("language") language: String = "en-US"
    ): MoviesResponse
}