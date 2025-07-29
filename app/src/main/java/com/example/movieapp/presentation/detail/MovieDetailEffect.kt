package com.example.movieapp.presentation.detail

sealed interface MovieDetailEffect {
    data object NavigateToBack: MovieDetailEffect
}