package com.example.presentation.ui.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.presentation.ui.horizontalmodules.nowplayingmovies.NowPlayingMoviesModule
import com.example.presentation.ui.horizontalmodules.popularmovies.PopularMoviesModule
import com.example.presentation.ui.horizontalmodules.topratedmovies.TopRatedMoviesModule
import com.example.presentation.ui.horizontalmodules.upcomingmovies.UpcomingMoviesModule

@Composable
fun HomeScreen(navController: NavHostController) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            NowPlayingMoviesModule(navController)
        }
        item {
            PopularMoviesModule(navController)
        }
        item {
            TopRatedMoviesModule(navController)
        }
        item {
            UpcomingMoviesModule(navController)
        }
    }
}
