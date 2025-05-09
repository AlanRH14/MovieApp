package com.example.movieapp.di

import com.example.movieapp.common.movie.ApiMapper
import com.example.movieapp.data.mapper_impl.movie.MovieApiMapperImpl
import com.example.movieapp.data.mapper_impl.movie_detail.MovieDetailMapperImpl
import com.example.movieapp.data.remote.models.movie.MovieDto
import com.example.movieapp.data.remote.models.movie_detail.MovieDetailDto
import com.example.movieapp.domain.models.movie.Movie
import com.example.movieapp.domain.models.movie_detail.MovieDetail
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiMapperModule {

    @Provides
    @Singleton
    fun provideMovieApiMapper(): ApiMapper<List<Movie>, MovieDto> =
        MovieApiMapperImpl()

   @Provides
   @Singleton
   fun provideDetailApiMapper(): ApiMapper<MovieDetail, MovieDetailDto> =
       MovieDetailMapperImpl()
}