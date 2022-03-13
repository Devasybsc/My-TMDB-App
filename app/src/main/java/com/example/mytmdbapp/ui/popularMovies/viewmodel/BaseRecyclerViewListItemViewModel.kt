package com.example.mytmdbapp.ui.popularMovies.viewmodel

import androidx.annotation.LayoutRes

abstract class BaseRecyclerViewListItemViewModel(
    var position: Int = -1,
    @LayoutRes val layoutResourceId: Int = -1
) {
    abstract fun getRecyclerviewIdentifier(): Int

    fun getItemPosition(): Int = position

    fun setItemPosition(index: Int) {
        position = index
    }
}