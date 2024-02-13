package com.example.presentation.ui.horizontalmodules.popularmovies

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.presentation.ui.horizontalmodules.HorizontalModule

@Composable
fun PopularMoviesModule(navController: NavHostController) {
    HorizontalModule(
        viewModel = hiltViewModel<PopularMoviesModuleViewModel>(),
        navController = navController,
        title = "Popular"
    )
}
