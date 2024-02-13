package com.example.data.repository.datasource

import com.example.domain.entity.Movie
import com.example.domain.entity.MovieDetails

interface MovieExternalDataSource {
    suspend fun authenticate()
    suspend fun searchMovie(query: String): List<Movie>
    suspend fun getNowPlayingMovies(): List<Movie>
    suspend fun getPopularMovies(): List<Movie>
    suspend fun getTopRatedMovies(): List<Movie>
    suspend fun getUpcomingMovies(): List<Movie>
    suspend fun getToDiscoverMovies(): List<Movie>
    suspend fun getMovieDetails(id: Int): MovieDetails
}
