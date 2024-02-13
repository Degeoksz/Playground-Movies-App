package com.example.presentation.ui.horizontalmodules

import androidx.compose.runtime.Immutable
import com.example.domain.entity.Movie

@Immutable
sealed class HorizontalModuleState {
    object Started : HorizontalModuleState()

    data class LoadedMovies(val movies: List<Movie>) : HorizontalModuleState()

    data class FailedLoadingMovies(val throwable: Throwable) : HorizontalModuleState()
}
