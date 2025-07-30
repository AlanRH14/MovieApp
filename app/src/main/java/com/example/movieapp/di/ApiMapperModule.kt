package com.example.movieapp.di

import com.example.movieapp.common.movie.ApiMapper
import com.example.movieapp.data.mapper_impl.movie.MovieApiMapperImpl
import com.example.movieapp.data.mapper_impl.movie_detail.MovieDetailMapperImpl
import com.example.movieapp.data.remote.models.movie.MovieDto
import com.example.movieapp.data.remote.models.movie_detail.MovieDetailDto
import com.example.movieapp.domain.models.movie.Movie
import com.example.movieapp.domain.models.movie_detail.MovieDetail
import org.koin.core.qualifier.named
import org.koin.dsl.module

val apiMapperModule = module {
    single<ApiMapper<MovieDto, List<Movie>>>(named("MovieApiMapper")) { MovieApiMapperImpl() }

    single<ApiMapper<MovieDetailDto, MovieDetail>>(named("MovieDetailApiMapper")) { MovieDetailMapperImpl() }
}