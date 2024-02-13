package com.example.playgroundmoviesapp.usecase

import com.example.domain.entity.Movie
import com.example.domain.repository.MovieRepository
import com.example.domain.usecase.SearchMovieUseCase
import javax.inject.Inject

class SearchMovieUseCaseImpl @Inject constructor(private val movieRepository: MovieRepository) :
    SearchMovieUseCase {
    override suspend fun invoke(query: String): List<Movie> = movieRepository.searchMovie(query)
}
