package com.example.movieapp.presentation.detail.mvi

sealed interface MovieDetailEffect {
    data object NavigateToBack: MovieDetailEffect
    data class NavigateToMovieDetail(val movieID: Int): MovieDetailEffect
}