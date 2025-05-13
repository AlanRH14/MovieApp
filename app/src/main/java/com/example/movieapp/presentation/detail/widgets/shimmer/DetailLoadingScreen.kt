package com.example.movieapp.presentation.detail.widgets.shimmer

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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.presentation.components.shimmer.HeaderMovieListShimmer
import com.example.movieapp.presentation.components.shimmer.shimmerEffect
import com.example.movieapp.presentation.detail.components.shimmer.ActorItemShimmer
import com.example.movieapp.ui.theme.ItemSpacing
import com.example.movieapp.ui.theme.VerySmallPadding

@Composable
fun DetailLoadingScreen(
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
            val bodyItemHeight = boxHeight * .56F

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = topItemHeight)
                    .shimmerEffect()
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = bodyItemHeight)
                    .align(Alignment.BottomCenter)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceContainerHighest,
                        shape = RoundedCornerShape(
                            topStart = 12.dp,
                            topEnd = 12.dp
                        )
                    )
                    .padding(ItemSpacing)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = ItemSpacing),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .height(12.dp)
                            .weight(0.4F)
                            .shimmerEffect()
                    )

                    Spacer(modifier = Modifier.weight(0.5F))

                    Box(
                        modifier = Modifier
                            .height(12.dp)
                            .weight(0.1F)
                            .shimmerEffect()
                    )
                }

                Spacer(modifier = Modifier.height(ItemSpacing))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .shimmerEffect()
                )

                Spacer(modifier = Modifier.height(ItemSpacing))

                repeat(3) {
                    Box(
                        modifier = Modifier
                            .padding(vertical = 1.dp)
                            .fillMaxWidth()
                            .height(12.dp)
                            .shimmerEffect()
                    )
                }

                Spacer(modifier = Modifier.height(ItemSpacing))

                Row {
                    repeat(3) {
                        Box(
                            modifier = Modifier
                                .padding(horizontal = VerySmallPadding)
                                .clip(RoundedCornerShape(50))
                                .size(32.dp)
                                .shimmerEffect()
                        )
                    }
                }

                HeaderMovieListShimmer()

                ActorItemShimmer()

                Spacer(modifier = Modifier.height(ItemSpacing))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .height(16.dp)
                            .weight(0.4F)
                            .shimmerEffect()
                    )

                    Box(
                        modifier = Modifier
                            .padding(horizontal = VerySmallPadding)
                            .height(12.dp)
                            .weight(0.3F)
                            .shimmerEffect()
                    )

                    Spacer(modifier = Modifier.weight(0.1F))
                }

                Spacer(modifier = Modifier.height(ItemSpacing))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .height(16.dp)
                            .weight(0.4F)
                            .shimmerEffect()
                    )

                    Box(
                        modifier = Modifier
                            .padding(horizontal = VerySmallPadding)
                            .height(12.dp)
                            .weight(0.3F)
                            .shimmerEffect()
                    )

                    Spacer(modifier = Modifier.weight(0.1F))
                }

                Spacer(modifier = Modifier.padding(ItemSpacing))

                Row {
                    Box(
                        modifier = Modifier
                            .height(20.dp)
                            .weight(0.3F)
                            .shimmerEffect()
                    )

                    Spacer(modifier = Modifier.weight(0.7F))
                }

                Spacer(modifier = Modifier.height(ItemSpacing))

                Row {
                    Box(
                        modifier = Modifier
                            .height(12.dp)
                            .weight(0.3F)
                            .shimmerEffect()
                    )

                    Spacer(modifier = Modifier.weight(0.7F))
                }

                Spacer(modifier = Modifier.height(ItemSpacing))

                repeat(3) {
                    Box(
                        modifier = Modifier
                            .padding(vertical = 1.dp)
                            .fillMaxWidth()
                            .height(12.dp)
                            .shimmerEffect()
                    )
                }

                Spacer(modifier = Modifier.height(VerySmallPadding))

                Row {
                    Box(
                        modifier = Modifier
                            .height(14.dp)
                            .weight(0.2F)
                            .shimmerEffect()
                    )

                    Spacer(modifier = Modifier.weight(0.8F))
                }

                Spacer(modifier = Modifier.height(VerySmallPadding))

                Row {
                    Box(
                        modifier = Modifier
                            .height(12.dp)
                            .weight(0.1F)
                            .shimmerEffect()
                    )

                    Spacer(modifier = Modifier.weight(0.9F))
                }
            }
        }
    }
}

@Preview
@Composable
private fun DetailLoadingScreenPreview() {
    DetailLoadingScreen(
        isLoading = true
    )
}