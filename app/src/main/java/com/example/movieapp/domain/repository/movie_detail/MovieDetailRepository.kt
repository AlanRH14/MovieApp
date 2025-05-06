package com.example.movieapp.domain.repository.movie_detail

import com.example.movieapp.domain.models.movie.Movie
import com.example.movieapp.domain.models.movie_detail.MovieDetail
import com.example.movieapp.utils.Response
import kotlinx.coroutines.flow.Flow

interface MovieDetailRepository {
    fun fetchMovieDetail(movie: Int): Flow<Response<MovieDetail>>

    fun fetchMovie(): Flow<Response<List<Movie>>>
}