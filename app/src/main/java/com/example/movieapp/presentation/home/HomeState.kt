package com.example.movieapp.presentation.home

import com.example.movieapp.domain.models.movie.Movie

data class HomeState(
    val discoverMovies: List<Movie> = emptyList(),
    val trendingMovies: List<Movie> = emptyList(),
    val error: String? = null,
    val isLoading: Boolean = false
)
