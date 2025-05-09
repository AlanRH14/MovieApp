package com.example.movieapp.di

import com.example.movieapp.data.remote.api.movie.MovieApiService
import com.example.movieapp.data.remote.api.movie_detail.MovieDetailApiService
import com.example.movieapp.utils.Keys.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private val json = Json {
        coerceInputValues = true
        ignoreUnknownKeys = true
    }

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory(contentType = contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieApiService(retrofit: Retrofit): MovieApiService =
        retrofit.create(MovieApiService::class.java)

    @Provides
    @Singleton
    fun provideMovieDetailApiService(retrofit: Retrofit): MovieDetailApiService =
        retrofit.create(MovieDetailApiService::class.java)
}
