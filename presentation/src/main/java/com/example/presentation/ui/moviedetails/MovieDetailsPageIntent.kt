package com.example.presentation.ui.moviedetails

sealed class MovieDetailsPageIntent {
    data class LoadMovieDetailsPage(val id: Int) : MovieDetailsPageIntent()
}
