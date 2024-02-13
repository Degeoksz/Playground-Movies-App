package com.example.presentation.ui.horizontalmodules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetMoviesUseCase
import com.example.domain.usecase.MovieListType
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class HorizontalModuleViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val movieListType: MovieListType
) : ViewModel() {
    private val _state = MutableStateFlow<HorizontalModuleState>(HorizontalModuleState.Started)
    val state: StateFlow<HorizontalModuleState>
        get() = _state

    val intentChannel = Channel<HorizontalModuleIntent>(Channel.UNLIMITED)

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            intentChannel.consumeAsFlow().collect { intent ->
                when (intent) {
                    is HorizontalModuleIntent.LoadMovies -> fetchMovies()
                }
            }
        }
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            _state.update {
                try {
                    HorizontalModuleState.LoadedMovies(getMoviesUseCase(movieListType))
                } catch (e: Exception) {
                    HorizontalModuleState.FailedLoadingMovies(e)
                }
            }
        }
    }
}