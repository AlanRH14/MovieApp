package com.example.movieapp.navigation

sealed interface Route {
    data object HomeScreen : Route
    data class FilmScreen(val movieID: Int) : Route
}