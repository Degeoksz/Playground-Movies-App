package com.example.presentation.ui.searchmovie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.SearchMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchMoviePageViewModel @Inject constructor(
    private val searchMovieUseCase: SearchMovieUseCase
): ViewModel() {
    private val _state = MutableStateFlow<SearchMoviePageState>(SearchMoviePageState.Started)
    val state: StateFlow<SearchMoviePageState>
        get() = _state

    val intentChannel = Channel<SearchMoviePageIntent>(Channel.UNLIMITED)

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            intentChannel.consumeAsFlow().collect { intent ->
                when (intent) {
                    is SearchMoviePageIntent.SearchMovieMoviePage -> searchMovie(intent.query)
                }
            }
        }
    }

    private fun searchMovie(query: String) {
        viewModelScope.launch {
            _state.update {
                try {
                    SearchMoviePageState.FindedMovies(searchMovieUseCase(query))
                } catch(e: Exception) {
                    SearchMoviePageState.FailedSearchingMovies(e)
                }
            }
        }
    }
}
