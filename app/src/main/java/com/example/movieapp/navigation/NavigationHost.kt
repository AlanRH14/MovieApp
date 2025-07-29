package com.example.movieapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.movieapp.presentation.detail.MovieDetailScreen
import com.example.movieapp.presentation.home.HomeScreen

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    NavHost(
        modifier = modifier.fillMaxSize(),
        navController = navController,
        startDestination = Route.HomeScreen
    ) {
        composable<Route.HomeScreen> {
            HomeScreen(navController = navController)
        }

        composable<Route.FilmScreen> { detailScreen ->
            val movieID = detailScreen.toRoute<Route.FilmScreen>().movieID
            MovieDetailScreen(
                movieID = movieID,
                navController = navController
            )
        }
    }
}