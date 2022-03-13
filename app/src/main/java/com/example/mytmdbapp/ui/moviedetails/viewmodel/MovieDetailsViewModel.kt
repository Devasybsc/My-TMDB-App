package com.example.mytmdbapp.ui.moviedetails.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mytmdbapp.model.Movie
import javax.inject.Inject

class MovieDetailsViewModel @Inject constructor() : ViewModel() {

    val popularMoviesList: LiveData<Movie> = MutableLiveData()

    fun setMovie(movie: Movie) {
        (popularMoviesList as MutableLiveData).postValue(movie)
    }
}