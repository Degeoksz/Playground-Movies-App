package com.example.presentation.ui.searchmovie

sealed class SearchMoviePageIntent {
    data class SearchMovieMoviePage(val query: String): SearchMoviePageIntent()
}
