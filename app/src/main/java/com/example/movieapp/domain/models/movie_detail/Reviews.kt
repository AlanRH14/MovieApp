package com.example.movieapp.domain.models.movie_detail

data class Reviews(
    val author: String,
    val content: String,
    val id: String,
    val createdAt: String,
    val rating: Double
)