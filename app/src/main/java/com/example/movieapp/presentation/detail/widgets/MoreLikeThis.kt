package com.example.movieapp.presentation.detail.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.movieapp.domain.models.movie.Movie
import com.example.movieapp.presentation.home.components.MovieCoverImage

@Composable
fun MoreLikeThis(
    modifier: Modifier = Modifier,
    fetchMovies: () -> Unit,
    isMovieLoading: Boolean,
    movies: List<Movie>,
    onMovieClick: (Int) -> Unit
) {
    LaunchedEffect(key1 = true) {
        fetchMovies()
    }

    Column(modifier = modifier) {
        Text(
            text = "More like this",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        LazyRow {
            item {
                AnimatedVisibility(visible = isMovieLoading) {
                    CircularProgressIndicator()
                }
            }

            items(movies) { movie ->
                MovieCoverImage(
                    movie = movie,
                    onMovieClick = onMovieClick
                )
            }
        }
    }
}