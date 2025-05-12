package com.example.movieapp.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.movieapp.R
import com.example.movieapp.domain.models.movie.Movie
import com.example.movieapp.presentation.components.GenericImage
import com.example.movieapp.ui.theme.ItemSpacing
import com.example.movieapp.ui.theme.VerySmallPadding

@Composable
fun MovieCoverImage(
    modifier: Modifier = Modifier,
    movie: Movie,
    onMovieClick: (id: Int) -> Unit
) {
    Box(
        modifier = modifier
            .size(
                width = 150.dp,
                height = 250.dp
            )
            .padding(ItemSpacing)
            .clickable { onMovieClick(movie.id) },
    ) {
        GenericImage(
            modifier = Modifier
                .matchParentSize()
                .clip(MaterialTheme.shapes.medium)
                .shadow(elevation = 4.dp),
            pathImage = movie.posterPath,
            contentDescription = stringResource(R.string.image_movie_cover),
        )
        MovieCard(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(VerySmallPadding),
            shape = CircleShape,
        ) {
            Icon(
                modifier = Modifier
                    .padding(VerySmallPadding),
                imageVector = Icons.Default.Bookmark,
                contentDescription = stringResource(R.string.bookmark_icon)
            )
        }
        Surface(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            color = Color.Black.copy(alpha = 0.8F),
            contentColor = Color.White,
            shape = RoundedCornerShape(
                bottomEnd = 30.dp,
                bottomStart = 30.dp
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = movie.title,
                    textAlign = TextAlign.Center,
                    maxLines = 1
                )
            }
        }
    }
}