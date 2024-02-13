package com.example.data.service

import com.example.data.mapper.MovieDetailsResponseToMovieDetailsMapper
import com.example.data.mapper.MovieResultResponseToMovieMapper
import com.example.data.repository.datasource.MovieExternalDataSource
import com.example.data.service.api.MovieApi
import com.example.domain.entity.Movie
import com.example.domain.entity.MovieDetails
import javax.inject.Inject

internal class MovieService @Inject constructor(
    private val movieApi: MovieApi,
    private val movieResultResponseToMovieMapper: MovieResultResponseToMovieMapper,
    private val movieDetailsResultResponseToMovieMapper: MovieDetailsResponseToMovieDetailsMapper
) : MovieExternalDataSource {
    override suspend fun authenticate() {
        movieApi.authenticate()
    }

    override suspend fun searchMovie(query: String): List<Movie> {
        return movieApi.searchMovie(query).body()?.results?.map {
            movieResultResponseToMovieMapper.transform(it)
        } ?: emptyList()
    }

    override suspend fun getNowPlayingMovies(): List<Movie> {
        return movieApi.nowPlayingMovies().body()?.results?.map {
            movieResultResponseToMovieMapper.transform(it)
        } ?: emptyList()
    }

    override suspend fun getPopularMovies(): List<Movie> {
        return movieApi.popularMovies().body()?.results?.map {
            movieResultResponseToMovieMapper.transform(it)
        } ?: emptyList()
    }

    override suspend fun getTopRatedMovies(): List<Movie> {
        return movieApi.topRatedMovies().body()?.results?.map {
            movieResultResponseToMovieMapper.transform(it)
        } ?: emptyList()
    }

    override suspend fun getUpcomingMovies(): List<Movie> {
        return movieApi.upcomingMovies().body()?.results?.map {
            movieResultResponseToMovieMapper.transform(it)
        } ?: emptyList()
    }

    override suspend fun getToDiscoverMovies(): List<Movie> {
        return movieApi.discoverMovies().body()?.results?.map {
            movieResultResponseToMovieMapper.transform(it)
        } ?: emptyList()
    }

    override suspend fun getMovieDetails(id: Int): MovieDetails {
        return movieDetailsResultResponseToMovieMapper.transform(movieApi.movieDetails(id).body())
    }
}
