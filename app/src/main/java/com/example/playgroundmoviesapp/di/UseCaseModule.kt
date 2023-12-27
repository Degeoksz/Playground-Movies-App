package com.example.playgroundmoviesapp.di

import com.example.domain.usecase.GetMoviePreviewUseCase
import com.example.playgroundmoviesapp.usecase.GetMoviePreviewUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class UseCaseModule {
    @Binds
    abstract fun bindGetMoviePreviewUseCase(impl: GetMoviePreviewUseCaseImpl): GetMoviePreviewUseCase
}
