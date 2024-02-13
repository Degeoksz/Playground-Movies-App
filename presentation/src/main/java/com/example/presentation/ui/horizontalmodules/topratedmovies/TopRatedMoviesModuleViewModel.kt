package com.example.presentation.ui.horizontalmodules.topratedmovies

import com.example.domain.usecase.GetMoviesUseCase
import com.example.domain.usecase.MovieListType
import com.example.presentation.ui.horizontalmodules.HorizontalModuleViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopRatedMoviesModuleViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : HorizontalModuleViewModel(getMoviesUseCase, MovieListType.TopRated)
