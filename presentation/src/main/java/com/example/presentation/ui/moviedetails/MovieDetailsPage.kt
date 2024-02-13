package com.example.presentation.ui.moviedetails

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.entity.MovieDetails

@Composable
fun MovieDetailsPage(movieId: Int) {
    val viewModel = hiltViewModel<MovieDetailsPageViewModel>()
    val state by viewModel.state.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (val innerState = state) {
            MovieDetailsPageState.Started -> {
                item {
                    Text("Loading...")
                }
            }

            is MovieDetailsPageState.FailedLoadingMovieDetailsPage -> {
                item {
                    Text("Failed loading movies")
                }
            }

            is MovieDetailsPageState.LoadedMovieDetailsPage -> {
                item {
                    MovieDetailsSection(innerState.movieDetails)
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.intentChannel.send(MovieDetailsPageIntent.LoadMovieDetailsPage(movieId))
    }
}

@Composable
private fun MovieDetailsSection(movieDetails: MovieDetails) {
    Text(movieDetails.title)
}