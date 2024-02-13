package com.example.presentation.ui.horizontalmodules.nowplayingmovies

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.presentation.ui.horizontalmodules.HorizontalModule

@Composable
fun NowPlayingMoviesModule(navController: NavHostController) {
    HorizontalModule(
        viewModel = hiltViewModel<NowPlayingMoviesModuleViewModel>(),
        navController = navController,
        title = "Now Playing"
    )
}
