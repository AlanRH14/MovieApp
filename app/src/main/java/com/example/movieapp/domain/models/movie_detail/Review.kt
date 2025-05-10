package com.example.movieapp.domain.models.movie_detail

data class Review(
    val author: String,
    val content: String,
    val id: String,
    val createdAt: String,
    val rating: Double
)