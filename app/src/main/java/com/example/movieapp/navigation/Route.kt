package com.example.movieapp.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object HomeScreen : Route
    @Serializable
    data class FilmScreen(val movieID: Int) : Route
}