package com.example.domain.repository

import com.example.domain.entity.Movie
import com.example.domain.entity.MovieDetails

interface MovieRepository {
    // TODO: Evaluate if authenticate method can be placed into a different repository
    suspend fun authenticate()
    suspend fun searchMovie(query: String): List<Movie>
    suspend fun getNowPlayingMovies(): List<Movie>
    suspend fun getPopularMovies(): List<Movie>
    suspend fun getTopRatedMovies(): List<Movie>
    suspend fun getUpcomingMovies(): List<Movie>
    suspend fun getToDiscoverMovies(): List<Movie>
    suspend fun getMovieDetails(id: Int): MovieDetails
}
