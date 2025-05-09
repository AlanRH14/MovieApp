package com.example.movieapp.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.movieapp.R
import com.example.movieapp.domain.models.movie.Movie
import com.example.movieapp.presentation.components.GenericImage
import com.example.movieapp.presentation.home.widgets.MovieDetail
import com.example.movieapp.ui.theme.ItemSpacing

@Composable
fun TopContent(
    modifier: Modifier = Modifier,
    movie: Movie,
    onMovieClick: (id: Int) -> Unit
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onMovieClick(movie.id) }
    ) {
        GenericImage(
            modifier = Modifier.matchParentSize(),
            pathImage = movie.posterPath,
            contentDescription = stringResource(R.string.movie_image),
            placeholder = painterResource(id = R.drawable.bg_image_movie)
        )

        MovieDetail(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(ItemSpacing),
            rating = movie.voteAverage,
            title = movie.title,
            genre = movie.genreIds
        )
    }
}