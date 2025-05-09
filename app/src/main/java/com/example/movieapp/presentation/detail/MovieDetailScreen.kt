package com.example.movieapp.presentation.detail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.movieapp.presentation.detail.widgets.DetailTopContent

@Composable
fun MovieDetailScreen(
    modifier: Modifier = Modifier,
    movieDetailViewModel: MovieDetailViewModel = hiltViewModel(),
    onNavigateUp: () -> Unit,
    onMovieClick: (Int) -> Unit,
    onActorClick: (Int) -> Unit
) {
    val state by movieDetailViewModel.detailState.collectAsStateWithLifecycle()

    Box(modifier = Modifier.fillMaxWidth()) {
        AnimatedVisibility(
            modifier = Modifier.align(Alignment.TopCenter),
            visible = state.error != null,
        ) {
            Text(
                text = state.error ?: "Unknown",
                color = MaterialTheme.colorScheme.error,
                maxLines = 2
            )

        }

        AnimatedVisibility(
            visible = !state.isLoading && state.error == null
        ) {
            BoxWithConstraints(
                modifier = Modifier.fillMaxSize()
            ) {
                val boxHeight = maxHeight
                val topItemHeight = boxHeight * 0.4F
                val bodyItemHeight = boxHeight * 0.6F

                state.movieDetail?.let { movieDetail ->
                    DetailTopContent(
                        modifier = Modifier
                            .height(topItemHeight)
                            .align(Alignment.TopCenter),
                        movieDetail = movieDetail,
                    )
                }
            }
        }
    }
}