package com.example.movieapp.presentation.detail

import com.example.movieapp.domain.models.movie.Movie
import com.example.movieapp.domain.models.movie_detail.MovieDetail

data class DetailState(
    val movieDetail: MovieDetail? = null,
    val movies: List<Movie> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null,
    val isMovieLoading: Boolean = false
)
