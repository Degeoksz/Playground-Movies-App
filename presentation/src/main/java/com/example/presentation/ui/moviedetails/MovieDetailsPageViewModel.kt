package com.example.presentation.ui.moviedetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsPageViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<MovieDetailsPageState>(MovieDetailsPageState.Started)
    val state: StateFlow<MovieDetailsPageState>
        get() = _state

    val intentChannel = Channel<MovieDetailsPageIntent>(Channel.UNLIMITED)

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            intentChannel.consumeAsFlow().collect { intent ->
                when (intent) {
                    is MovieDetailsPageIntent.LoadMovieDetailsPage -> fetchMovieDetails(intent.id)
                }
            }
        }
    }

    private fun fetchMovieDetails(id: Int) {
        viewModelScope.launch {
            _state.update {
                try {
                    MovieDetailsPageState.LoadedMovieDetailsPage(getMovieDetailsUseCase(id))
                } catch(e: Exception) {
                    MovieDetailsPageState.FailedLoadingMovieDetailsPage(e)
                }
            }
        }
    }
}
