package com.example.mytmdbapp.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.mytmdbapp.R

object ImageViewBindingAdapters {

    @JvmStatic
    @BindingAdapter(
        value = [
            "imageUrl"
        ],
        requireAll = false
    )
    fun loadImageUrl(
        imageView: ImageView,
        imageUrl: String?
    ) {
        imageUrl?.let {
            Glide.with(imageView.context)
                .load(it) // image url
                .placeholder(R.drawable.banner_loading) // any placeholder to load at start
                .error(R.drawable.banner_error)  // any image in case of error
                .centerCrop()
                .into(imageView)
        }
    }


    @JvmStatic
    @BindingAdapter("visible")
    fun setBooleanVisibility(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }
}