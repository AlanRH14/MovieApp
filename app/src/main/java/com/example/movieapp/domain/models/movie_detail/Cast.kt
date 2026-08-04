package com.example.movieapp.domain.models.movie_detail

data class Cast(
    val id: Int,
    val fistName: String,
    val lastName: String,
    val genderRole: String,
    val character: String,
    val profilePath: String,
)