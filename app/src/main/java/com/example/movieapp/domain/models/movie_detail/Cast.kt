package com.example.movieapp.domain.models.movie_detail

data class Cast(
    val id: Int,
    val name: String,
    val genderRole: String,
    val character: String,
    val profilePath: String,
) {
    private val nameParts = name.split(" ", limit = 2)
    val fistName = nameParts[0]
    val lastName = nameParts[1]
}