package com.example.movieapp.domain.models.movie_detail

data class MovieDetail(
    val backdropPath: String,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
    val voteCount: Int,
    val video: Boolean,
    val cast: List<Cast>,
    val language: List<String>,
    val reviews: Reviews,
)