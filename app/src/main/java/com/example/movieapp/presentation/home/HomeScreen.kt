package com.example.movieapp.presentation.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.movieapp.presentation.home.widgets.TopContent
import com.example.movieapp.presentation.home.widgets.BodyContent
import com.example.movieapp.presentation.home.widgets.shimmer.HomeLoadingScreen
import com.example.movieapp.ui.theme.DefaultPadding
import com.example.movieapp.ui.theme.ItemSpacing
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
    onMovieClick: (id: Int) -> Unit
) {
    var isAutoScrolling by remember {
        mutableStateOf(true)
    }
    val state by homeViewModel.homeState.collectAsStateWithLifecycle()
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { state.discoverMovies.size }
    )
    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()

    LaunchedEffect(key1 = pagerState.currentPage) {
        if (isDragged) {
            isAutoScrolling = false
        } else {
            isAutoScrolling = true
            delay(5000)
            with(pagerState) {
                val target = if (currentPage < state.discoverMovies.size - 1)
                    currentPage + 1
                else 0
                scrollToPage(target)
            }
        }
    }

    HomeLoadingScreen(isLoading = state.isLoading)

    Box(
        modifier = modifier
    ) {
        AnimatedVisibility(
            visible = state.error != null
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
                modifier = Modifier
                    .fillMaxSize()
            ) {
                val boxHeight = maxHeight
                val topItemHeight = boxHeight * .45F
                val bodyItemHeight = boxHeight * .56F

                HorizontalPager(
                    state = pagerState,
                    contentPadding = PaddingValues(all = DefaultPadding),
                    pageSize = PageSize.Fill,
                    pageSpacing = ItemSpacing
                ) { page ->
                    if (isAutoScrolling) {
                        AnimatedContent(
                            targetState = page,
                            label = ""
                        ) { index ->
                            TopContent(
                                modifier = Modifier
                                    .heightIn(min = topItemHeight)
                                    .align(Alignment.TopCenter),
                                movie = state.discoverMovies[index],
                                onMovieClick = { onMovieClick(it) }
                            )
                        }
                    } else {
                        TopContent(
                            modifier = Modifier
                                .heightIn(min = topItemHeight)
                                .align(Alignment.TopCenter),
                            movie = state.discoverMovies[page],
                            onMovieClick = { onMovieClick(it) }
                        )
                    }
                }

                BodyContent(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .heightIn(max = bodyItemHeight),
                    discoverMovies = state.discoverMovies,
                    trendingMovies = state.trendingMovies,
                    onMovieClick = onMovieClick
                )
            }
        }
    }
}