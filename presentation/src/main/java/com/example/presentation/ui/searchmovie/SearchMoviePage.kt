package com.example.presentation.ui.searchmovie

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchMoviePage(onNavigateToDetails: (movieId: Int) -> Unit) {
    val viewModel = hiltViewModel<SearchMoviePageViewModel>()
    val state by viewModel.state.collectAsState()
    var query by remember { mutableStateOf("") }

    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        Row(Modifier.fillMaxWidth()) {
            TextField(
                value = query,
                onValueChange = { query = it })
            Button(onClick = {
                coroutineScope.launch {
                    viewModel.intentChannel.send(SearchMoviePageIntent.SearchMovieMoviePage(query))
                }
            }) {
                Text("Search")
            }
        }
        when (val innerState = state) {
            is SearchMoviePageState.Started -> {
                // Do nothing for now
            }

            is SearchMoviePageState.FindedMovies -> {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier.fillMaxSize()
                ) {
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

            is SearchMoviePageState.FailedSearchingMovies -> {
                Text("Failed loading movies")
            }
        }
    }
}