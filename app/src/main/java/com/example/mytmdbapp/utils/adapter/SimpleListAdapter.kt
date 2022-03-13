package com.example.mytmdbapp.utils.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.mytmdbapp.ui.popularMovies.viewmodel.BaseRecyclerViewListItemViewModel
import com.example.mytmdbapp.BR

open class SimpleListAdapter<T : BaseRecyclerViewListItemViewModel>(
    diffCallback: DiffUtil.ItemCallback<T>? = null,
    private val callback: Any? = null,
    private val lifecycleOwner: LifecycleOwner? = null
) : ListAdapter<T, ViewDatabindingHolder>(
    diffCallback ?: object : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem.getRecyclerviewIdentifier() == newItem.getRecyclerviewIdentifier()
        }

        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem.getRecyclerviewIdentifier() == newItem.getRecyclerviewIdentifier()
        }
    }
) {
    override fun getItemViewType(position: Int): Int =
        (getItem(position) as BaseRecyclerViewListItemViewModel).layoutResourceId

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewDatabindingHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            viewType,
            parent,
            false
        )
        callback?.let {
            binding.setVariable(BR.callback, callback)
        }

        lifecycleOwner?.let {
            binding.setVariable(BR.lifeOwner, it)
            binding.lifecycleOwner = it
        }

        return ViewDatabindingHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: ViewDatabindingHolder, position: Int) {
        holder.binding.setVariable(BR.viewModel, getItem(position))
    }
}