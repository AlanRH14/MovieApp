package com.example.movieapp.di

import com.example.movieapp.data.remote.repository.movie.MovieRepositoryImpl
import com.example.movieapp.domain.repository.movie.MovieRepository
import org.koin.dsl.module

val movieModule = module {
    single<MovieRepository> {
        MovieRepositoryImpl(
            movieApiService = get(),
            apiMapper = get()
        )
    }
}