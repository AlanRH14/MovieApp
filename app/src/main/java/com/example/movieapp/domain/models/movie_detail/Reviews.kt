package com.example.movieapp.domain.models.movie_detail

data class Reviews(
    val page: Int,
    val results: List<Result>,
    val totalPages: Int,
    val totalResults: Int,
)