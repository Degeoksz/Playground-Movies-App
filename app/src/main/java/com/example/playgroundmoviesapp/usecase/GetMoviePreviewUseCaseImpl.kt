package com.example.playgroundmoviesapp.usecase

import com.example.domain.entity.MoviePreview
import com.example.domain.usecase.GetMoviePreviewUseCase
import javax.inject.Inject

// TODO: Implement the data access through a repository
class GetMoviePreviewUseCaseImpl @Inject constructor() : GetMoviePreviewUseCase {
    override suspend fun invoke(): List<MoviePreview> =
        listOf(
            MoviePreview("Shrek 1"),
            MoviePreview("Shrek 2")
        )
}