package com.example.data.di

import com.example.data.repository.datasource.MovieExternalDataSource
import com.example.data.service.MovieService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ServiceModule {
    @Binds
    internal abstract fun bindMovieService(impl: MovieService): MovieExternalDataSource
}
