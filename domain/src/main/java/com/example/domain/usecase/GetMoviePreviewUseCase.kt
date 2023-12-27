package com.example.domain.usecase

import com.example.domain.entity.MoviePreview

interface GetMoviePreviewUseCase {
    suspend operator fun invoke(): List<MoviePreview>
}