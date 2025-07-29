package com.example.movieapp.presentation.home.mvi

sealed interface HomeUIEvent {
    data class OnMovieClicked(val movieID: Int): HomeUIEvent
    data object OnFetchDiscoverMovie: HomeUIEvent
    data object OnFetchTrendingMovie: HomeUIEvent
}