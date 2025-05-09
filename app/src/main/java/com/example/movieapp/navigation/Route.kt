package com.example.movieapp.navigation

import com.example.movieapp.utils.NavigationKeys.FILM_SCREEN
import com.example.movieapp.utils.NavigationKeys.HOME_SCREEN

sealed class Route {
    data class HomeScreen( val route: String = HOME_SCREEN) : Route()

    data class FilmScreen(
        val route: String = FILM_SCREEN,
        val routeWithArgs: String = "$route/{id}"
    ): Route() {
        fun getRouteWithArgs(id: Int): String {
            return "$route/$id"
        }
    }
}