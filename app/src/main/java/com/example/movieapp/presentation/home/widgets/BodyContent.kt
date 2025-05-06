package com.example.movieapp.presentation.home.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.movieapp.R
import com.example.movieapp.domain.models.Movie
import com.example.movieapp.presentation.home.components.HeaderMovieList
import com.example.movieapp.presentation.home.components.MovieCoverImage

@Composable
fun BodyContent(
    modifier: Modifier = Modifier,
    discoverMovies: List<Movie>,
    trendingMovies: List<Movie>,
    onMovieClick: (id: Int) -> Unit
) {

    LazyColumn(modifier = modifier) {
        item {
            Card(modifier = Modifier.fillMaxWidth()) {
                HeaderMovieList(title = stringResource(R.string.discover_movies))

                LazyRow {
                    items(discoverMovies) { discoverMovie ->
                        MovieCoverImage(
                            movie = discoverMovie,
                            onMovieClick = onMovieClick
                        )
                    }
                }

                HeaderMovieList(title = stringResource(R.string.trending_now))

                LazyRow {
                    items(trendingMovies) { trendingMovie ->
                        MovieCoverImage(
                            movie = trendingMovie,
                            onMovieClick = onMovieClick
                        )
                    }
                }
            }
        }
    }
}