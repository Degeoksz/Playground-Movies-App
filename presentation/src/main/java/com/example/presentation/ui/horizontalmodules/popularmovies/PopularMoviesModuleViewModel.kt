package com.example.presentation.ui.horizontalmodules.popularmovies

import com.example.domain.usecase.GetMoviesUseCase
import com.example.domain.usecase.MovieListType
import com.example.presentation.ui.horizontalmodules.HorizontalModuleViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PopularMoviesModuleViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : HorizontalModuleViewModel(getMoviesUseCase, MovieListType.Popular)
