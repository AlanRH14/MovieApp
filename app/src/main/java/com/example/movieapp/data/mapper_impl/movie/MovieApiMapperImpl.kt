package com.example.movieapp.data.mapper_impl.movie

import com.example.movieapp.common.movie.ApiMapper
import com.example.movieapp.data.remote.models.movie.MovieDto
import com.example.movieapp.domain.models.movie.Movie
import com.example.movieapp.utils.GenreConstants

class MovieApiMapperImpl : ApiMapper<List<Movie>, MovieDto> {

    override fun mapToDomain(apiDto: MovieDto): List<Movie> {
        return apiDto.results?.map { result ->
            Movie(
                backdropPath = formatEmptyValue(result?.backdropPath),
                genreIds = formatGere(result?.genreIds),
                id = result?.id ?: 0,
                originalLanguage = formatEmptyValue(result?.originalLanguage, default = "language"),
                originalTitle = formatEmptyValue(result?.originalTitle, default = "title"),
                overview = formatEmptyValue(result?.overview, default = "overview"),
                popularity = result?.popularity ?: 0.0,
                posterPath = formatEmptyValue(result?.posterPath),
                releaseDate = formatEmptyValue(result?.releaseDate, default = "date"),
                title = formatEmptyValue(result?.title, default = "title"),
                voteAverage = result?.voteAverage ?: 0.0,
                voteCount = result?.voteCount ?: 0,
                video = result?.video ?: false
            )
        } ?: emptyList()
    }

    private fun formatEmptyValue(value: String?, default: String = ""): String {
        return if (value.isNullOrEmpty()) {
            "Unknown $default"
        } else {
            value
        }
    }

    private fun formatGere(genreIds: List<Int?>?): List<String> {
        return genreIds?.map {
            GenreConstants.getGenreNameById(it ?: 0)
        } ?: emptyList()
    }
}