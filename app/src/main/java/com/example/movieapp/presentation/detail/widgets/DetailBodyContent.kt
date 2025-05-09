package com.example.movieapp.presentation.detail.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.movieapp.domain.models.movie.Movie
import com.example.movieapp.domain.models.movie_detail.MovieDetail
import com.example.movieapp.ui.theme.DefaultPadding
import com.example.movieapp.ui.theme.ItemSpacing
import com.example.movieapp.ui.theme.SmallPadding

@Composable
fun DetailBodyContent(
    modifier: Modifier = Modifier,
    movieDetail: MovieDetail,
    movies: List<Movie>,
    isMovieLoading: Boolean,
    fetchMovies: () -> Unit,
    onMovieClick: (Int) -> Unit,
    onActorClick: (Int) -> Unit
) {
    LazyColumn(modifier) {
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(DefaultPadding)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {

                        movieDetail.genreIds.forEachIndexed { index, genreText ->
                            Text(
                                modifier = Modifier
                                    .padding(SmallPadding),
                                text = genreText,
                                maxLines = 1,
                                style = MaterialTheme.typography.bodySmall
                            )

                            if (index < movieDetail.genreIds.lastIndex) {
                                Text(
                                    text = " \u2022 ",
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }

                        Text(
                            text = movieDetail.runtime,
                            style = MaterialTheme.typography.bodySmall,
                            textAlign = TextAlign.Center
                        )
                    }

                    Spacer(modifier = Modifier.height(ItemSpacing))

                    Text(
                        text = movieDetail.title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                    )

                    Spacer(modifier = Modifier.height(ItemSpacing))

                    Text(
                        text = movieDetail.overview,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(ItemSpacing))
                }
            }
        }
    }
}
