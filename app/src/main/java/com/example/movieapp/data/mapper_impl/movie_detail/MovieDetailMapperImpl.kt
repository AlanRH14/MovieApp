package com.example.movieapp.data.mapper_impl.movie_detail

import com.example.movieapp.common.movie.ApiMapper
import com.example.movieapp.data.remote.models.movie_detail.CastDto
import com.example.movieapp.data.remote.models.movie_detail.MovieDetailDto
import com.example.movieapp.domain.models.movie_detail.Cast
import com.example.movieapp.domain.models.movie_detail.MovieDetail
import com.example.movieapp.domain.models.movie_detail.Review
import com.example.movieapp.utils.FormatValue.toDecimalValue
import java.text.SimpleDateFormat
import java.util.Locale

class MovieDetailMapperImpl : ApiMapper<MovieDetailDto, MovieDetail> {

    private fun formatTimeStamp(
        patternInput: String = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
        patternOutput: String = "E, MMM d, yy",
        time: String
    ): String {
        val inputDateFormatter = SimpleDateFormat(patternInput, Locale.US)
        val outputDateFormatter = SimpleDateFormat(
            patternOutput,
            Locale.getDefault()
        )
        val date = inputDateFormatter.parse(time)
        val formattedDate = date?.let { outputDateFormatter.format(it) } ?: time

        return formattedDate
    }

    private fun convertMinutesToHours(minutes: Int): String {
        val hours = minutes / 60
        val remainingMinutes = minutes % 60
        return "${hours}h:${remainingMinutes}m"
    }

    private fun formatEmptyValue(value: String?, default: String = ""): String {
        return if (value.isNullOrEmpty()) {
            "Unknown $default"
        } else {
            value
        }
    }

    private fun formatCast(castDto: List<CastDto?>?): List<Cast> {
        return castDto?.map {
            val genderRole = if (it?.gender == 2) "Actor" else "Actress"
            Cast(
                id = it?.id ?: 0,
                name = formatEmptyValue(it?.name),
                genderRole = genderRole,
                character = formatEmptyValue(it?.character),
                profilePath = it?.profilePath ?: ""
            )
        } ?: emptyList()
    }

    override fun mapToDomain(apiDto: MovieDetailDto): MovieDetail {
        return MovieDetail(
            backdropPath = formatEmptyValue(apiDto.backdropPath),
            genreIds = apiDto.genres?.map { formatEmptyValue(it?.name) } ?: emptyList(),
            id = apiDto.id ?: 0,
            originalLanguage = formatEmptyValue(apiDto.originalLanguage, "language"),
            originalTitle = formatEmptyValue(apiDto.originalTitle, "title"),
            overview = formatEmptyValue(apiDto.overview, "overview"),
            popularity = apiDto.popularity?.toDecimalValue() ?: 0.0,
            posterPath = formatEmptyValue(apiDto.posterPath),
            releaseDate = formatTimeStamp(
                patternInput = "yyyy-MM-dd",
                time = apiDto.releaseDate ?: "0"
            ),
            title = formatEmptyValue(apiDto.title, "title"),
            voteAverage = apiDto.voteAverage?.toDecimalValue() ?: 0.0,
            voteCount = apiDto.voteCount ?: 0,
            video = apiDto.video ?: false,
            cast = formatCast(apiDto.credits?.cast),
            language = apiDto.spokenLanguages?.map { formatEmptyValue(it?.englishName) }
                ?: emptyList(),
            productionCountries = apiDto.productionCountries?.map { formatEmptyValue(it?.name) }
                ?: emptyList(),
            reviews = apiDto.reviews?.results?.map {
                Review(
                    author = formatEmptyValue(it?.author),
                    content = formatEmptyValue(it?.content),
                    createdAt = formatTimeStamp(time = it?.createdAt ?: "0"),
                    id = formatEmptyValue(it?.id),
                    rating = it?.authorDetails?.rating ?: 0.0
                )
            } ?: emptyList(),
            runtime = convertMinutesToHours(apiDto.runtime ?: 0)
        )
    }
}