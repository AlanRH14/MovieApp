package com.example.movieapp.presentation.home.widgets.shimmer

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.presentation.components.shimmer.shimmerEffect
import com.example.movieapp.presentation.components.shimmer.HeaderMovieListShimmer
import com.example.movieapp.ui.theme.DefaultPadding
import com.example.movieapp.ui.theme.ItemSpacing

@Composable
fun HomeLoadingScreen(
    modifier: Modifier = Modifier,
    isLoading: Boolean
) {
    AnimatedVisibility(
        visible = isLoading,
        enter = fadeIn() + expandVertically()
    ) {
        BoxWithConstraints(
            modifier = modifier
                .fillMaxSize()
        ) {
            val boxHeight = maxHeight
            val topItemHeight = boxHeight * .45F
            val bodyItemHeight = boxHeight * .55F

            Box(
                modifier
                    .fillMaxWidth()
                    .heightIn(min = topItemHeight)
            ) {
                Row(
                    modifier = Modifier
                        .padding(all = DefaultPadding)
                        .matchParentSize(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    repeat(3) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(ItemSpacing)
                                .shimmerEffect()
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .heightIn(max = bodyItemHeight)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceContainerHighest,
                        shape = RoundedCornerShape(
                            topStart = 12.0.dp,
                            topEnd = 12.0.dp
                        )
                    )
            ) {

                HeaderMovieListShimmer()

                Row {
                    repeat(4) {
                        Box(
                            modifier = Modifier
                                .size(
                                    width = 150.dp,
                                    height = 250.dp
                                )
                                .padding(ItemSpacing)
                                .shimmerEffect()
                        )
                    }
                }

                Spacer(modifier = Modifier.height(ItemSpacing))

                HeaderMovieListShimmer()

                Row {
                    repeat(4) {
                        Box(
                            modifier = Modifier
                                .size(
                                    width = 150.dp,
                                    height = 250.dp
                                )
                                .padding(ItemSpacing)
                                .shimmerEffect()
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun LoadingScreenPreview() {
    HomeLoadingScreen(
        isLoading = true
    )
}

