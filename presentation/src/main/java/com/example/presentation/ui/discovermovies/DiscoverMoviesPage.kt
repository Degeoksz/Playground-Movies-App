package com.example.presentation.ui.discovermovies

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

@Composable
fun DiscoverMoviesPage(onNavigateToDetails: (movieId: Int) -> Unit) {
    val viewModel = hiltViewModel<DiscoverMoviesPageViewModel>()
    val state by viewModel.state.collectAsState()
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize()
    ) {
        when (val innerState = state) {
            DiscoverMoviesState.Started -> {
                item {
                    Text("Loading...")
                }
            }

            is DiscoverMoviesState.FailedLoadingMovies -> {
                item {
                    Text("Failed loading movies")
                }
            }

            is DiscoverMoviesState.LoadedMovies -> {
                items(innerState.movies) {
                    AsyncImage(
                        model = it.posterUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .height(200.dp)
                            .clickable { onNavigateToDetails(it.id) }
                    )
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.intentChannel.send(DiscoverMoviesIntent.LoadMovies)
    }
}