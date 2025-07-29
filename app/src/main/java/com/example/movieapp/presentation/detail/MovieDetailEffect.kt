package com.example.movieapp.presentation.detail

sealed interface MovieDetailEffect {
    data object NavigateToBack: MovieDetailEffect
    data class NavigateToMovieDetail(val movieID: Int): MovieDetailEffect
}