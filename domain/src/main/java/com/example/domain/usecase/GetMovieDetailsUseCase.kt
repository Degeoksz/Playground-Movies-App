package com.example.domain.usecase

import com.example.domain.entity.MovieDetails

interface GetMovieDetailsUseCase {
    suspend operator fun invoke(id: Int): MovieDetails
}
