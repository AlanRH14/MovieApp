package com.example.movieapp.presentation.home

sealed interface HomeEffect {
    data class NavigateToDetailMovie(val movieID: Int): HomeEffect
}