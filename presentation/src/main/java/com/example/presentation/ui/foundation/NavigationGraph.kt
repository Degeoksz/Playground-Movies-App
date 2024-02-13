package com.example.presentation.ui.foundation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.presentation.ui.discovermovies.DiscoverMoviesPage
import com.example.presentation.ui.moviedetails.MovieDetailsPage
import com.example.presentation.ui.home.HomeScreen
import com.example.presentation.ui.searchmovie.SearchMoviePage

@Composable
fun NavigationGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppRoutes.Home.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(AppRoutes.Home.route) {
            HomeScreen(navController)
        }
        composable(AppRoutes.Discover.route) {
            DiscoverMoviesPage(onNavigateToDetails = { movieId ->
                navController.navigate("$DETAILS_PATH$movieId")
            })
        }
        composable(AppRoutes.Search.route) {
            SearchMoviePage(onNavigateToDetails = { movieId ->
                navController.navigate("$DETAILS_PATH$movieId")
            })
        }
        composable(
            route = AppRoutes.Details.route,
            arguments = listOf(navArgument(MOVIE_ID) { type = NavType.IntType })
        ) { backStackEntry ->
            MovieDetailsPage(backStackEntry.arguments?.getInt(MOVIE_ID) ?: 0)
        }
    }
}
