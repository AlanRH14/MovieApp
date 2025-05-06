package com.example.movieapp.di

import com.example.movieapp.common.movie.ApiMapper
import com.example.movieapp.data.mapper_impl.MovieApiMapperImpl
import com.example.movieapp.data.remote.api.MovieApiService
import com.example.movieapp.data.remote.models.movie.MovieDto
import com.example.movieapp.data.remote.repository.MovieRepositoryImpl
import com.example.movieapp.domain.models.movie.Movie
import com.example.movieapp.domain.repository.movie.MovieRepository
import com.example.movieapp.utils.Keys
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
object MovieModule {

    private val json = Json {
        coerceInputValues = true
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun providesMovieRepository(
        movieApiService: MovieApiService,
        apiMapper: ApiMapper<List<Movie>, MovieDto>
    ): MovieRepository = MovieRepositoryImpl(
        movieApiService = movieApiService,
        apiMapper = apiMapper
    )

    @Provides
    @Singleton
    fun providesMovieMapper(): ApiMapper<List<Movie>, MovieDto> =
        MovieApiMapperImpl()

    @Provides
    @Singleton
    fun provideMovieApiService(): MovieApiService {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(Keys.BASE_URL)
            .addConverterFactory(json.asConverterFactory(contentType = contentType))
            .build()
            .create(MovieApiService::class.java)
    }
}