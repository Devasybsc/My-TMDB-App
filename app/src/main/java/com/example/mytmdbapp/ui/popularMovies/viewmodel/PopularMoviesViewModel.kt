package com.example.mytmdbapp.ui.popularMovies.viewmodel

import androidx.databinding.Observable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytmdbapp.usecases.GetMovieListUseCase
import javax.inject.Inject
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PopularMoviesViewModel @Inject constructor(
    val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {

    val popularMoviesList: LiveData<List<BaseRecyclerViewListItemViewModel>> = MutableLiveData()

    val errorEnabled = ObservableBoolean(false)
    val exception: ObservableField<String> = ObservableField("").apply {
        addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                errorEnabled.set((sender as? String).isNullOrBlank())
            }
        })
    }

    init {
        loadMovies()
    }

    private fun loadMovies() {
        val movieList = popularMoviesList.value ?: emptyList()

        viewModelScope.launch {
            val flow = getMovieListUseCase.getPopularMovies()
            try {
                flow.collect { movies ->
                    movies.map {
                        MovieListViewModel(
                            it
                        )
                    }.let {
                        (popularMoviesList as MutableLiveData).postValue(movieList + it)
                    }
                }
            } catch (e: Exception) {
                exception.set(e.message)
            }
        }
    }
}