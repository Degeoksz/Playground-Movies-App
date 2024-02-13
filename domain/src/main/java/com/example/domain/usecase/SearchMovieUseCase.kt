package com.example.domain.usecase

import com.example.domain.entity.Movie

interface SearchMovieUseCase {
    suspend operator fun invoke(query: String): List<Movie>
}
