package com.example.mytmdbapp.model

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("page") val pageNumber: Int,
    @SerializedName("results") val movieList: List<Movie>
)