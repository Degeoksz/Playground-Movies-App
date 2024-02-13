package com.example.presentation.ui.searchmovie

import com.example.domain.entity.Movie

sealed class SearchMoviePageState {
    object Started : SearchMoviePageState()

    data class FindedMovies(val movies: List<Movie>) : SearchMoviePageState()

    data class FailedSearchingMovies(val exception: Throwable) : SearchMoviePageState()
}
