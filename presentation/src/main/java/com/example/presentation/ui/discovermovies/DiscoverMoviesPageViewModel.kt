package com.example.presentation.ui.discovermovies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetMoviesUseCase
import com.example.domain.usecase.MovieListType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiscoverMoviesPageViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<DiscoverMoviesState>(DiscoverMoviesState.Started)
    val state: StateFlow<DiscoverMoviesState>
        get() = _state

    val intentChannel = Channel<DiscoverMoviesIntent>(Channel.UNLIMITED)

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            intentChannel.consumeAsFlow().collect { intent ->
                when (intent) {
                    is DiscoverMoviesIntent.LoadMovies -> fetchToDiscoverMovies()
                }
            }
        }
    }

    private fun fetchToDiscoverMovies() {
        viewModelScope.launch {
            _state.update {
                try {
                    DiscoverMoviesState.LoadedMovies(getMoviesUseCase(MovieListType.ToDiscover))
                } catch(e: Exception) {
                    DiscoverMoviesState.FailedLoadingMovies(e)
                }
            }
        }
    }
}