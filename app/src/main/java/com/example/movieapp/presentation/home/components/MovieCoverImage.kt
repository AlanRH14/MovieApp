package com.example.movieapp.presentation.home.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.request.ImageRequest
import com.example.movieapp.domain.models.Movie
import com.example.movieapp.utils.Keys.BASE_IMAGE_URL

@Composable
fun MovieCoverImage(
    modifier: Modifier = Modifier,
    movie: Movie,
    onMovieClick: (id: Int) -> Unit
) {
    val imageRequest = ImageRequest.Builder(LocalContext.current)
        .data("$BASE_IMAGE_URL${movie.posterPath}")
        .crossfade(true)
        .build()
}