package com.example.mytmdbapp.ui.popularMovies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mytmdbapp.usecases.GetMovieListUseCase
import javax.inject.Inject

class PopularMoviesViewModelFactory @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
) : ViewModelProvider.Factory {

    override fun <ViewModelClass : ViewModel> create(
        modelClass: Class<ViewModelClass>
    ): ViewModelClass {
        if (modelClass.isAssignableFrom(PopularMoviesViewModel::class.java)) {
            return PopularMoviesViewModel(
                getMovieListUseCase = getMovieListUseCase
            ) as ViewModelClass
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}