package com.example.movieapp.data.remote.repository.movie_detail

import com.example.movieapp.common.movie.ApiMapper
import com.example.movieapp.data.remote.api.movie_detail.MovieDetailApiService
import com.example.movieapp.data.remote.models.movie.MovieDto
import com.example.movieapp.data.remote.models.movie_detail.MovieDetailDto
import com.example.movieapp.domain.models.movie.Movie
import com.example.movieapp.domain.models.movie_detail.MovieDetail
import com.example.movieapp.domain.repository.movie_detail.MovieDetailRepository
import com.example.movieapp.common.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class MovieDetailRepositoryImpl(
    private val movieDetailApiService: MovieDetailApiService,
    private val apiDetailMapper: ApiMapper<MovieDetailDto, MovieDetail>,
    private val apiMovieMapper: ApiMapper<MovieDto, List<Movie>>
) : MovieDetailRepository {

    override fun fetchMovieDetail(movieId: Int): Flow<Response<MovieDetail>> = flow {
        emit(Response.Loading)
        val movieDetailDto = movieDetailApiService.fetchMovieDetail(movieId = movieId)
        apiDetailMapper.mapToDomain(movieDetailDto).apply {
            emit(Response.Success(this))
        }
    }.catch { error ->
        error.printStackTrace()
        emit(Response.Error(error))
    }

    override fun fetchMovie(): Flow<Response<List<Movie>>> = flow {
        emit(Response.Loading)
        val movieDto = movieDetailApiService.fetchMovie()
        apiMovieMapper.mapToDomain(movieDto).apply {
            emit(Response.Success(this))
        }
    }.catch { error ->
        error.printStackTrace()
        emit(Response.Error(error))
    }
}