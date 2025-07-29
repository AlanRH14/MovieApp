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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.movieapp.navigation.Route
import com.example.movieapp.presentation.detail.mvi.DetailEffect
import com.example.movieapp.presentation.detail.mvi.DetailUIEvent
import com.example.movieapp.presentation.detail.widgets.DetailBodyContent
import com.example.movieapp.presentation.detail.widgets.DetailTopContent
import com.example.movieapp.presentation.detail.widgets.shimmer.DetailLoadingScreen
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    detailViewModel: DetailViewModel = koinViewModel(),
    movieID: Int = -1,
    navController: NavHostController,
) {
    val state by detailViewModel.detailState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        detailViewModel.onEvent(DetailUIEvent.OnFetchDetailById(movieID = movieID))

        detailViewModel.effect.collectLatest { effect ->
            when (effect) {
                is DetailEffect.NavigateToBack -> navController.popBackStack()
                is DetailEffect.NavigateToDetail -> {
                    navController.navigate(Route.FilmScreen(movieID = effect.movieID)) {
                        launchSingleTop = true
                        popUpTo(navController.graph.findStartDestination().id) {
                            inclusive = false
                        }
                    }
                }
            }
        }
    }

    DetailLoadingScreen(isLoading = state.isLoading)

    Box(modifier = modifier.fillMaxWidth()) {
        AnimatedVisibility(
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
                        onEvent = detailViewModel::onEvent
                    )

                    DetailBodyContent(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .height(bodyItemHeight),
                        movieDetail = movieDetail,
                        movies = state.movies,
                        isMovieLoading = state.isMovieLoading,
                        onEvent = detailViewModel::onEvent,
                    )
                }
            }
        }
    }
}