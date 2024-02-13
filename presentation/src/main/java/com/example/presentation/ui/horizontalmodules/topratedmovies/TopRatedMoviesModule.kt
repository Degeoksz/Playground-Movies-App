package com.example.presentation.ui.horizontalmodules.topratedmovies

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.presentation.ui.horizontalmodules.HorizontalModule

@Composable
fun TopRatedMoviesModule(navController: NavHostController) {
    HorizontalModule(
        viewModel = hiltViewModel<TopRatedMoviesModuleViewModel>(),
        navController = navController,
        title = "Top Rated"
    )
}