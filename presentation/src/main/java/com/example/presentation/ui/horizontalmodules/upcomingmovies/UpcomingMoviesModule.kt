package com.example.presentation.ui.horizontalmodules.upcomingmovies

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.presentation.ui.horizontalmodules.HorizontalModule

@Composable
fun UpcomingMoviesModule(navController: NavHostController) {
    HorizontalModule(
        viewModel = hiltViewModel<UpcomingMoviesModuleViewModel>(),
        navController = navController,
        title = "Upcoming"
    )
}
