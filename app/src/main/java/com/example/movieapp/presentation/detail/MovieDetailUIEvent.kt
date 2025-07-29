package com.example.movieapp.presentation.detail

sealed interface MovieDetailUIEvent {
    data class OnFetchMovieDetailById(val movieID: Int) : MovieDetailUIEvent
    data object OnFetchMovie : MovieDetailUIEvent
    data object OnNavigateToBack: MovieDetailUIEvent
}