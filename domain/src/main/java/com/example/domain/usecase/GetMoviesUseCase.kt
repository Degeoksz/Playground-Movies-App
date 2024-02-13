package com.example.domain.usecase

import com.example.domain.entity.Movie

enum class MovieListType {
    ToDiscover,
    NowPlaying,
    Popular,
    TopRated,
    Upcoming
}

interface GetMoviesUseCase {
    suspend operator fun invoke(movieListType: MovieListType): List<Movie>
}
