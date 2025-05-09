package com.example.movieapp.di

import com.example.movieapp.common.movie.ApiMapper
import com.example.movieapp.data.mapper_impl.movie.MovieApiMapperImpl
import com.example.movieapp.data.remote.models.movie.MovieDto
import com.example.movieapp.domain.models.movie.Movie
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
    fun provideApiMapper(): ApiMapper<List<Movie>, MovieDto> =
        MovieApiMapperImpl()
}