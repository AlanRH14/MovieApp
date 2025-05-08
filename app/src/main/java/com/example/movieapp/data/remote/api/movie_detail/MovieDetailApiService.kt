package com.example.movieapp.data.remote.api.movie_detail

import com.example.movieapp.data.remote.models.movie.MovieDto
import com.example.movieapp.data.remote.models.movie_detail.MovieDetailDto
import com.example.movieapp.utils.Keys.API_KEY
import com.example.movieapp.utils.Keys.MOVIE_DETAIL_ENDPOINT
import com.example.movieapp.utils.Keys.MOVIE_ENDPOINT
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailApiService {

    @GET("${MOVIE_DETAIL_ENDPOINT}/{id}")
    suspend fun fetchMovieDetail(
        @Path("id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("append_to_response") appendToResponse: String = "credits,reviews"
    ): MovieDetailDto

    @GET(MOVIE_ENDPOINT)
    suspend fun fetchMovie(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("include_adult") includeAdult: Boolean = false
    ): MovieDto
}