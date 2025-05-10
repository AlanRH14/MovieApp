package com.example.movieapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
        startDestination = Route.HomeScreen().route
    ) {
        composable(
            route = Route.HomeScreen().route,
        ) {
            HomeScreen(
                onMovieClick = {
                    navController.navigate(Route.FilmScreen().getRouteWithArgs(id = it)) {
                        launchSingleTop = true
                        popUpTo(navController.graph.findStartDestination().id) {
                            inclusive = false
                        }
                    }
                }
            )
        }

        composable(
            route = Route.FilmScreen().routeWithArgs,
            arguments = listOf(navArgument(name = "id") { type = NavType.IntType })
        ) {
            MovieDetailScreen(
                onNavigateUp = { navController.navigateUp() },
                onMovieClick = {
                    navController.navigate(Route.FilmScreen().getRouteWithArgs(id = it)) {
                        launchSingleTop = true
                        popUpTo(navController.graph.findStartDestination().id) {
                            inclusive = false
                        }
                    }
                },
                onActorClick = {}
            )
        }
    }
}