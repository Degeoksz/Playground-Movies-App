package com.example.data.service.api

import com.example.data.service.api.response.AuthenticateResponse
import com.example.data.service.api.response.MovieListResponse
import com.example.data.service.api.response.MovieDetailsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val MOVIE_ID = "movieId"

internal interface MovieApi {
    @GET("3/authentication")
    suspend fun authenticate(): Response<AuthenticateResponse>

    @GET("3/search/movie")
    suspend fun searchMovie(@Query("query") query: String): Response<MovieListResponse>

    @GET("3/movie/now_playing")
    suspend fun nowPlayingMovies(): Response<MovieListResponse>

    @GET("3/movie/popular")
    suspend fun popularMovies(): Response<MovieListResponse>

    @GET("3/movie/top_rated")
    suspend fun topRatedMovies(): Response<MovieListResponse>

    @GET("3/movie/upcoming")
    suspend fun upcomingMovies(): Response<MovieListResponse>

    @GET("3/discover/movie")
    suspend fun discoverMovies(): Response<MovieListResponse>

    @GET("3/movie/{$MOVIE_ID}")
    suspend fun movieDetails(@Path(MOVIE_ID) movieId: Int): Response<MovieDetailsResponse>
}
