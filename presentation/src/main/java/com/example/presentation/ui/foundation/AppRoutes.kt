package com.example.presentation.ui.foundation

const val DETAILS_PATH = "details/"
const val MOVIE_ID = "movieId"

enum class AppRoutes(val route: String) {
    Home("home"),
    Discover("discover"),
    Search("search"),
    Details("$DETAILS_PATH{$MOVIE_ID}")
}
