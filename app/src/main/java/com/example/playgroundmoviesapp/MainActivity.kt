package com.example.playgroundmoviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.presentation.ui.foundation.AppRoutes
import com.example.presentation.ui.foundation.NavigationGraph
import com.example.presentation.ui.foundation.theme.PlaygroundMoviesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val mainActivityViewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundMoviesAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomAppBar(
                            actions = {
                                IconButton(onClick = { navController.navigate(AppRoutes.Home.route) }) {
                                    Icon(Icons.Filled.Home, contentDescription = null)
                                }
                                IconButton(onClick = { navController.navigate(AppRoutes.Discover.route) }) {
                                    Icon(Icons.Filled.ExitToApp, contentDescription = null)
                                }
                                IconButton(onClick = { navController.navigate(AppRoutes.Search.route) }) {
                                    Icon(Icons.Filled.Search, contentDescription = null)
                                }
                            }
                        )
                    }
                ) { paddingValues ->
                    NavigationGraph(
                        navController = navController,
                        modifier = Modifier.padding(paddingValues)
                    )
                }
            }
        }
    }
}
