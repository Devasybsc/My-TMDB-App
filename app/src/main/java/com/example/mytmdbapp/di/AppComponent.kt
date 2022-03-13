package com.example.mytmdbapp.di

import android.content.Context
import com.example.mytmdbapp.TmdApplication
import com.example.mytmdbapp.ui.MainActivity
import com.example.mytmdbapp.ui.moviedetails.MovieDetailsFragment
import com.example.mytmdbapp.ui.popularMovies.PopularMoviesFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        DataSourceModule::class,
        MoviesModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }

    fun inject(application: TmdApplication)
    fun inject(fragment: PopularMoviesFragment)
    fun inject(mainActivity: MainActivity)
    fun inject(movieDetailsFragment: MovieDetailsFragment)

}