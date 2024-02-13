package com.example.data.repository

import com.example.data.repository.datasource.MovieExternalDataSource
import com.example.domain.entity.Movie
import com.example.domain.entity.MovieDetails
import com.example.domain.repository.MovieRepository
import javax.inject.Inject

internal class MovieRepositoryImpl @Inject constructor(
    private val movieExternalDataSource: MovieExternalDataSource
) : MovieRepository {
    override suspend fun authenticate(): Unit = movieExternalDataSource.authenticate()

    override suspend fun searchMovie(query: String): List<Movie> = movieExternalDataSource.searchMovie(query)

    override suspend fun getNowPlayingMovies(): List<Movie> = movieExternalDataSource.getNowPlayingMovies()

    override suspend fun getPopularMovies(): List<Movie> = movieExternalDataSource.getPopularMovies()

    override suspend fun getTopRatedMovies(): List<Movie> = movieExternalDataSource.getTopRatedMovies()

    override suspend fun getUpcomingMovies(): List<Movie> = movieExternalDataSource.getUpcomingMovies()

    override suspend fun getToDiscoverMovies(): List<Movie> = movieExternalDataSource.getToDiscoverMovies()

    override suspend fun getMovieDetails(id: Int): MovieDetails = movieExternalDataSource.getMovieDetails(id)
}
