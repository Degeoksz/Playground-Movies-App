package com.example.presentation.ui.moviedetails

import androidx.compose.runtime.Immutable
import com.example.domain.entity.MovieDetails

@Immutable
sealed class MovieDetailsPageState {
    object Started : MovieDetailsPageState()

    data class LoadedMovieDetailsPage(val movieDetails: MovieDetails) : MovieDetailsPageState()

    data class FailedLoadingMovieDetailsPage(val throwable: Throwable) : MovieDetailsPageState()
}
