package com.example.movieapp.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieapp.R
import com.example.movieapp.domain.models.Movie
import com.example.movieapp.presentation.home.widgets.MovieDetail
import com.example.movieapp.ui.theme.SmallPadding
import com.example.movieapp.utils.Keys.BASE_IMAGE_URL

@Composable
fun TopContent(
    modifier: Modifier = Modifier,
    movie: Movie,
    onMovieClick: (id: Int) -> Unit
) {
    val imgRequest = ImageRequest.Builder(LocalContext.current)
        .data("${BASE_IMAGE_URL}${movie.posterPath}")
        .crossfade(true)
        .build()

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onMovieClick(movie.id) }
    ) {
        AsyncImage(
            modifier = Modifier.matchParentSize(),
            model = imgRequest,
            contentDescription = stringResource(R.string.movie_image),
            contentScale = ContentScale.Crop,
            onError = {
                it.result.throwable.printStackTrace()
            },
            placeholder = painterResource(id = R.drawable.bg_image_movie)
        )

        MovieDetail(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(SmallPadding),
            rating = movie.voteAverage,
            title = movie.title,
            genre = movie.genreIds
        )
    }
}