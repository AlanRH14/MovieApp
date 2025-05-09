package com.example.movieapp.di

import com.example.movieapp.common.movie.ApiMapper
import com.example.movieapp.data.remote.api.movie.MovieApiService
import com.example.movieapp.data.remote.models.movie.MovieDto
import com.example.movieapp.data.remote.repository.movie.MovieRepositoryImpl
import com.example.movieapp.domain.models.movie.Movie
import com.example.movieapp.domain.repository.movie.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieModule {
    @Provides
    @Singleton
    fun provideMovieRepository(
        movieApiService: MovieApiService,
        apiMapper: ApiMapper<List<Movie>, MovieDto>
    ): MovieRepository = MovieRepositoryImpl(
        movieApiService = movieApiService,
        apiMapper = apiMapper
    )
}