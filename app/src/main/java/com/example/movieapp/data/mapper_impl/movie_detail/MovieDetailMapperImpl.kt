package com.example.movieapp.data.mapper_impl.movie_detail

import com.example.movieapp.common.movie.ApiMapper
import com.example.movieapp.data.remote.models.movie_detail.MovieDetailDto
import com.example.movieapp.domain.models.movie_detail.MovieDetail
import java.text.SimpleDateFormat
import java.util.Locale

class MovieDetailMapperImpl : ApiMapper<MovieDetail, MovieDetailDto> {

    private fun formatTimeStamp(pattern: String = "dd.MM.yy", time: String): String {
        val inputDateFormatter = SimpleDateFormat("yyyy-MMM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
        val outputDateFormatter = SimpleDateFormat(
            pattern,
            Locale.getDefault()
        )
        val date = inputDateFormatter.parse(time)
        val formattedDate = date?.let { outputDateFormatter.format(it) } ?: time

        return formattedDate
    }

    override fun mapToDomain(apiDto: MovieDetailDto): MovieDetail {
        TODO("Not yet implemented")
    }
}