package com.example.movieapp.di

import com.example.movieapp.common.movie.ApiMapper
import com.example.movieapp.data.remote.api.movie_detail.MovieDetailApiService
import com.example.movieapp.data.remote.models.movie.MovieDto
import com.example.movieapp.data.remote.models.movie_detail.MovieDetailDto
import com.example.movieapp.data.remote.repository.movie_detail.MovieDetailRepositoryImpl
import com.example.movieapp.domain.models.movie.Movie
import com.example.movieapp.domain.models.movie_detail.MovieDetail
import com.example.movieapp.domain.repository.movie_detail.MovieDetailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieDetailModule {

    @Provides
    @Singleton
    fun provideMovieDetail(
        movieDetailApiService: MovieDetailApiService,
        apiDetailMapper: ApiMapper<MovieDetail, MovieDetailDto>,
        apiMovieMapper: ApiMapper<List<Movie>, MovieDto>
    ) : MovieDetailRepository = MovieDetailRepositoryImpl(
        movieDetailApiService = movieDetailApiService,
        apiDetailMapper = apiDetailMapper,
        apiMovieMapper = apiMovieMapper,
    )
}