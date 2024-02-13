package com.example.playgroundmoviesapp.di

import com.example.domain.usecase.GetMovieDetailsUseCase
import com.example.domain.usecase.GetMoviesUseCase
import com.example.domain.usecase.SearchMovieUseCase
import com.example.playgroundmoviesapp.usecase.GetMovieDetailsUseCaseImpl
import com.example.playgroundmoviesapp.usecase.GetMoviesUseCaseImpl
import com.example.playgroundmoviesapp.usecase.SearchMovieUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    abstract fun bindSearchMovieUseCase(impl: SearchMovieUseCaseImpl): SearchMovieUseCase
    @Binds
    abstract fun bindGetNowPlayingMoviesUseCase(impl: GetMoviesUseCaseImpl): GetMoviesUseCase
    @Binds
    abstract fun bindGetMovieDetailsUseCase(impl: GetMovieDetailsUseCaseImpl): GetMovieDetailsUseCase
}
