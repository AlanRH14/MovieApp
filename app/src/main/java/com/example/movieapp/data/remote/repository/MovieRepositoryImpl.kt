package com.example.movieapp.data.remote.repository

import com.example.movieapp.common.movie.ApiMapper
import com.example.movieapp.data.remote.api.MovieApiService
import com.example.movieapp.data.remote.models.movie.MovieDto
import com.example.movieapp.domain.models.movie.Movie
import com.example.movieapp.domain.repository.MovieRepository
import com.example.movieapp.utils.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl(
    private val movieApiService: MovieApiService,
    private val apiMapper: ApiMapper<List<Movie>, MovieDto>
) : MovieRepository {
    override fun fetchDiscoverMovie(): Flow<Response<List<Movie>>> = flow {
        emit(Response.Loading)
        val movieDto = movieApiService.fetchDiscoverMovie()
        apiMapper.mapToDomain(movieDto).apply {
            emit(Response.Success(this))
        }
    }.catch { error ->
        emit(Response.Error(error))
    }

    override fun fetchTrendingMovie(): Flow<Response<List<Movie>>> = flow {
        emit(Response.Loading)
        val movieDto = movieApiService.fetchTrendingMovie()
        apiMapper.mapToDomain(movieDto).apply {
            emit(Response.Success(this))
        }
    }.catch { error ->
        emit(Response.Error(error))
    }
}