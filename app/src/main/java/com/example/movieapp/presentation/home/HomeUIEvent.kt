package com.example.movieapp.presentation.home

sealed interface HomeUIEvent {
    data class OnMovieClicked(val movieID: String): HomeUIEvent
    data object OnFetchDiscoverMovie: HomeUIEvent
}