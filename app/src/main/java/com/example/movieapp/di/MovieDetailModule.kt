package com.example.movieapp.di

import com.example.movieapp.data.remote.repository.movie_detail.MovieDetailRepositoryImpl
import com.example.movieapp.domain.repository.movie_detail.MovieDetailRepository
import org.koin.dsl.module

val movieDetailModule = module {

    single<MovieDetailRepository> {
        MovieDetailRepositoryImpl(
            movieDetailApiService = get(),
            apiDetailMapper = get(),
            apiMovieMapper = get(),
        )
    }
}