package com.example.movieapp.presentation.detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.movieapp.R
import com.example.movieapp.domain.models.movie_detail.MovieDetail
import com.example.movieapp.presentation.components.GenericImage

@Composable
fun DetailTopContent(
    modifier: Modifier = Modifier,
    movieDetail: MovieDetail
) {

    Box(modifier = modifier.fillMaxWidth()) {
        GenericImage(
            modifier = Modifier
                .matchParentSize(),
            pathImage = movieDetail.posterPath,
            contentDescription = stringResource(R.string.detail_top_image),
            placeholder = painterResource(id = R.drawable.bg_image_movie)
        )
    }
}