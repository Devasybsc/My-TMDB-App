package com.example.mytmdbapp.ui.popularMovies

import com.example.mytmdbapp.model.Movie

interface PopularRecyclerCallback {
    fun onMovieSelected(movie: Movie)
}