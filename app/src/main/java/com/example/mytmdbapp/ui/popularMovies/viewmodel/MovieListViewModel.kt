package com.example.mytmdbapp.ui.popularMovies.viewmodel

import com.example.mytmdbapp.R
import com.example.mytmdbapp.model.Movie

data class MovieListViewModel constructor(
    val movie: Movie? = null
) : BaseRecyclerViewListItemViewModel(layoutResourceId = R.layout.movie_list_item) {

    override fun getRecyclerviewIdentifier(): Int = hashCode()
}