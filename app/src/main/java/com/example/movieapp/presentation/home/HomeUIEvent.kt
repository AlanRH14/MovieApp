package com.example.movieapp.presentation.home

sealed interface HomeUIEvent {
    data class NavigateToMovieDetail(val movieID: String): HomeEffect
}