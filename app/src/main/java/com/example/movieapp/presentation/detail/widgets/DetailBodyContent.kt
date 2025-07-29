package com.example.movieapp.presentation.detail.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.movieapp.R
import com.example.movieapp.domain.models.movie.Movie
import com.example.movieapp.domain.models.movie_detail.MovieDetail
import com.example.movieapp.presentation.components.HeaderMovieList
import com.example.movieapp.presentation.detail.mvi.MovieDetailUIEvent
import com.example.movieapp.presentation.detail.components.ActionIconButton
import com.example.movieapp.presentation.detail.components.ActorItem
import com.example.movieapp.presentation.detail.components.GenreInfo
import com.example.movieapp.presentation.detail.components.MovieInfoItem
import com.example.movieapp.presentation.home.ActionIcon
import com.example.movieapp.ui.theme.DefaultPadding
import com.example.movieapp.ui.theme.ItemSpacing

@Composable
fun DetailBodyContent(
    modifier: Modifier = Modifier,
    movieDetail: MovieDetail,
    movies: List<Movie>,
    isMovieLoading: Boolean,
    onEvent: (MovieDetailUIEvent) -> Unit,
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

                    GenreInfo(
                        genreIds = movieDetail.genreIds,
                        runtime = movieDetail.runtime
                    )

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

                    Row(modifier = Modifier.fillMaxWidth()) {
                        ActionIcon.entries.forEachIndexed { index, actionIcon ->
                            ActionIconButton(
                                icon = actionIcon.icon,
                                contentDescription = actionIcon.contentDescription,
                                bgColor = if (index == ActionIcon.entries.lastIndex) {
                                    MaterialTheme.colorScheme.primaryContainer
                                } else {
                                    Color.Black.copy(0.8F)
                                }
                            )
                        }
                    }

                    HeaderMovieList(
                        title = stringResource(R.string.cast_crew),
                        contentDescription = stringResource(R.string.cast_crew_button)
                    )

                    LazyRow {
                        items(movieDetail.cast) { cast ->
                            ActorItem(
                                modifier = Modifier
                                    .weight(1F)
                                    .padding(horizontal = ItemSpacing)
                                    .clickable { onEvent(MovieDetailUIEvent.OnActorClicked(actorID = cast.id)) },
                                cast = cast
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(ItemSpacing))

                    MovieInfoItem(
                        infoItem = movieDetail.language,
                        title = stringResource(R.string.spoken_language),
                    )

                    Spacer(modifier = Modifier.height(ItemSpacing))

                    MovieInfoItem(
                        infoItem = movieDetail.productionCountries,
                        title = stringResource(R.string.production_countries)
                    )

                    Spacer(modifier = Modifier.height(ItemSpacing))

                    Text(
                        text = "Reviews",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                    )

                    Spacer(modifier = Modifier.height(ItemSpacing))

                    Reviews(reviews = movieDetail.reviews)

                    Spacer(modifier = Modifier.height(ItemSpacing))

                    MoreLikeThis(
                        fetchMovies = { onEvent(MovieDetailUIEvent.OnFetchMovie) },
                        isMovieLoading = isMovieLoading,
                        movies = movies,
                        onMovieClick = { onEvent(MovieDetailUIEvent.OnMovieClicked(movieID = it)) }
                    )
                }
            }
        }
    }
}
