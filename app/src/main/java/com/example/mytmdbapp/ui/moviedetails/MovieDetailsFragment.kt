package com.example.mytmdbapp.ui.moviedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mytmdbapp.databinding.FragmentMovieDetailsBinding
import com.example.mytmdbapp.di.DaggerProvider
import com.example.mytmdbapp.model.Movie
import com.example.mytmdbapp.ui.moviedetails.viewmodel.MovieDetailsViewModel

class MovieDetailsFragment : Fragment() {

    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!

    private val pageViewModel: MovieDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerProvider.getAppComponent()?.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<Movie>("movie")?.let {
            pageViewModel.setMovie(movie = it)
        }
        pageViewModel.popularMoviesList.observe(viewLifecycleOwner) {
            binding.movie = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}