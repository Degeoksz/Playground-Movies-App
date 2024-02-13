package com.example.presentation.ui.discovermovies

import androidx.compose.runtime.Immutable
import com.example.domain.entity.Movie

@Immutable
sealed class DiscoverMoviesState {
    object Started : DiscoverMoviesState()

    data class LoadedMovies(val movies: List<Movie>) : DiscoverMoviesState()

    data class FailedLoadingMovies(val throwable: Throwable): DiscoverMoviesState()
}
