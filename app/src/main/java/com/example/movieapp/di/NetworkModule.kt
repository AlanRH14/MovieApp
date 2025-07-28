package com.example.movieapp.di

import com.example.movieapp.data.remote.api.movie.MovieApiService
import com.example.movieapp.data.remote.api.movie_detail.MovieDetailApiService
import com.example.movieapp.utils.Keys.BASE_URL
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

private val json = Json {
    coerceInputValues = true
    ignoreUnknownKeys = true
}

private val contentType = "application/json".toMediaType()

val networkModule = module {

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get<OkHttpClient>())
            .addConverterFactory(json.asConverterFactory(contentType = contentType))
            .build()
    }


    single<MovieApiService> { get<Retrofit>().create(MovieApiService::class.java) }

    single<MovieDetailApiService> { get<Retrofit>().create(MovieDetailApiService::class.java) }
}
