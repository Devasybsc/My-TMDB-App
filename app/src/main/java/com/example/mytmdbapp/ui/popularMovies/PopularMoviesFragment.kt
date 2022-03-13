package com.example.mytmdbapp.ui.popularMovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.Observable
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytmdbapp.R
import com.example.mytmdbapp.databinding.FragmentPopularMoviesBinding
import com.example.mytmdbapp.di.DaggerAppComponent
import com.example.mytmdbapp.di.DaggerProvider
import com.example.mytmdbapp.model.Movie
import com.example.mytmdbapp.ui.popularMovies.viewmodel.BaseRecyclerViewListItemViewModel
import com.example.mytmdbapp.ui.popularMovies.viewmodel.PopularMoviesViewModel
import com.example.mytmdbapp.ui.popularMovies.viewmodel.PopularMoviesViewModelFactory
import com.example.mytmdbapp.utils.MarginItemDecoration
import com.example.mytmdbapp.utils.adapter.SimpleListAdapter
import javax.inject.Inject

/**
 * Fragment represents Popular Movies list & passes Movie details for MovieDetails Fragment
 */
class PopularMoviesFragment : Fragment(), PopularRecyclerCallback {

    private var _binding: FragmentPopularMoviesBinding? = null

    @Inject
    lateinit var popularMoviesViewModelFactory: PopularMoviesViewModelFactory

    private val pageViewModel: PopularMoviesViewModel by viewModels(
        factoryProducer = { popularMoviesViewModelFactory }
    )

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerProvider.getAppComponent()?.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPopularMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.errorEnabled = pageViewModel.errorEnabled
        val listAdapter = SimpleListAdapter<BaseRecyclerViewListItemViewModel>(
            callback = this,
            lifecycleOwner = this
        )
        binding.recyclerPopularMovies.setHasFixedSize(false)
        binding.recyclerPopularMovies.layoutManager = LinearLayoutManager(context)
        binding.recyclerPopularMovies.addItemDecoration(
            MarginItemDecoration(
                resources.getDimensionPixelSize(
                    R.dimen.recycler_spacing
                )
            )
        )
        binding.recyclerPopularMovies.adapter = listAdapter

        pageViewModel.popularMoviesList.observe(viewLifecycleOwner) {
            listAdapter.submitList(it)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onMovieSelected(movie: Movie) {
        val bundle = bundleOf("movie" to movie)
        findNavController().navigate(
            resId = R.id.action_PopularMoviesFragment_to_MovieDetailsFragment,
            args = bundle
        )
    }
}