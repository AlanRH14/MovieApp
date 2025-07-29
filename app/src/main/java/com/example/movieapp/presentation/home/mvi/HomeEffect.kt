package com.example.movieapp.presentation.home.mvi

sealed interface HomeEffect {
    data class NavigateToDetailMovie(val movieID: Int): HomeEffect
}