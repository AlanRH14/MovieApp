package com.example.movieapp.presentation.detail.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.movieapp.R
import com.example.movieapp.domain.models.movie_detail.MovieDetail
import com.example.movieapp.presentation.components.GenericImage
import com.example.movieapp.presentation.detail.mvi.MovieDetailUIEvent
import com.example.movieapp.presentation.detail.components.DetailComponent
import com.example.movieapp.ui.theme.ItemSpacing

@Composable
fun DetailTopContent(
    modifier: Modifier = Modifier,
    movieDetail: MovieDetail,
    onEvent: (MovieDetailUIEvent) -> Unit
) {

    Box(modifier = modifier.fillMaxWidth()) {
        IconButton(onClick = { onEvent(MovieDetailUIEvent.OnNavigateToBack) }) {
            Icon(
                modifier = Modifier.align(Alignment.TopStart),
                imageVector = Icons.AutoMirrored.Default.ArrowBackIos,
                tint = Color.Black,
                contentDescription = stringResource(R.string.navigate_up_icon),
            )
        }

        GenericImage(
            modifier = Modifier
                .matchParentSize(),
            pathImage = movieDetail.posterPath,
            contentDescription = stringResource(R.string.detail_top_image),
            placeholder = painterResource(id = R.drawable.bg_image_movie)
        )

        DetailComponent(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(ItemSpacing),
            rating = movieDetail.voteAverage,
            releaseDate = movieDetail.releaseDate,
        )
    }
}