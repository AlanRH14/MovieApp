package com.example.movieapp.presentation.detail

sealed interface MovieDetailUIEvent {
    data class OnFetchMovieDetailById(val movieID: Int): MovieDetailEffect
}