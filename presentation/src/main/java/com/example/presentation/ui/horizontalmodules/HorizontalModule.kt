package com.example.presentation.ui.horizontalmodules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.presentation.ui.foundation.DETAILS_PATH

@Composable
fun HorizontalModule(
    viewModel: HorizontalModuleViewModel = hiltViewModel(),
    navController: NavHostController, // TODO: Replace ref to navController with a callback function
    title: String
) {
    val state by viewModel.state.collectAsState()

    Text(title)
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        when (val innerState = state) {
            HorizontalModuleState.Started -> {
                item {
                    Text("Loading...")
                }
            }

            is HorizontalModuleState.LoadedMovies -> {
                items(innerState.movies) {
                    AsyncImage(
                        model = it.posterUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .clickable { navController.navigate("$DETAILS_PATH${it.id}") }
                    )
                }
            }

            is HorizontalModuleState.FailedLoadingMovies -> {
                item {
                    Text("Failed loading movies")
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.intentChannel.send(HorizontalModuleIntent.LoadMovies)
    }
}
