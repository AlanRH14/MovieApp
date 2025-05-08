package com.example.movieapp.data.remote.api.movie

import com.example.movieapp.data.remote.models.movie.MovieDto
import com.example.movieapp.utils.Keys.API_KEY
import com.example.movieapp.utils.Keys.MOVIE_ENDPOINT
import com.example.movieapp.utils.Keys.TRENDING_MOVIE_ENDPOINT
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET(MOVIE_ENDPOINT)
    suspend fun fetchDiscoverMovie(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("include_adult") includeAdult: Boolean = false
    ): MovieDto

    @GET(TRENDING_MOVIE_ENDPOINT)
    suspend fun fetchTrendingMovie(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("include_adult") includeAdult: Boolean = false
    ): MovieDto
}