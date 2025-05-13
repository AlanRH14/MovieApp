package com.example.movieapp.presentation.detail.widgets.shimmer

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.presentation.components.shimmer.HeaderMovieListShimmer
import com.example.movieapp.presentation.components.shimmer.shimmerEffect
import com.example.movieapp.ui.theme.DefaultPadding
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
                    .align(Alignment.BottomCenter)
                    .heightIn(max = bodyItemHeight)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceContainerHighest,
                        shape = RoundedCornerShape(
                            topStart = 12.dp,
                            topEnd = 12.dp
                        )
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(DefaultPadding),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .height(12.dp)
                            .fillMaxWidth()
                            .shimmerEffect()
                            .weight(0.4F)
                    )

                    Spacer(
                        modifier = Modifier.weight(0.5F)
                    )

                    Box(
                        modifier = Modifier
                            .height(12.dp)
                            .fillMaxWidth()
                            .weight(0.1F)
                            .shimmerEffect()
                    )
                }

                Spacer(modifier = Modifier.height(ItemSpacing))

                Box(
                    modifier = Modifier
                        .padding(all = ItemSpacing)
                        .fillMaxWidth()
                        .height(20.dp)
                        .shimmerEffect()
                )

                Box(
                    modifier = Modifier
                        .padding(horizontal = ItemSpacing, vertical = 1.dp)
                        .fillMaxWidth()
                        .height(12.dp)
                        .shimmerEffect()
                )

                Box(
                    modifier = Modifier
                        .padding(horizontal = ItemSpacing, vertical = 1.dp)
                        .fillMaxWidth()
                        .height(12.dp)
                        .shimmerEffect()
                )

                Box(
                    modifier = Modifier
                        .padding(horizontal = ItemSpacing, vertical = 1.dp)
                        .fillMaxWidth()
                        .height(12.dp)
                        .shimmerEffect()
                )

                Row(modifier = Modifier.padding(ItemSpacing)) {
                    repeat(3) {
                        Box(
                            modifier = Modifier
                                .padding(VerySmallPadding)
                                .clip(RoundedCornerShape(50))
                                .size(32.dp)
                                .shimmerEffect()
                        )
                    }
                }

                HeaderMovieListShimmer()

                Row(
                    modifier = Modifier
                        .padding(horizontal = ItemSpacing)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    repeat(8) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .padding(horizontal = ItemSpacing)
                                    .clip(CircleShape)
                                    .size(48.dp)
                                    .shimmerEffect()
                            )

                            Box(
                                modifier = Modifier
                                    .width(35.dp)
                                    .height(10.dp)
                                    .shimmerEffect()
                            )

                            Spacer(modifier = Modifier.height(VerySmallPadding))

                            Box(
                                modifier = Modifier
                                    .width(55.dp)
                                    .height(16.dp)
                                    .shimmerEffect()
                            )

                            Spacer(modifier = Modifier.height(1.dp))

                            Box(
                                modifier = Modifier
                                    .width(55.dp)
                                    .height(16.dp)
                                    .shimmerEffect()
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(ItemSpacing))

                Row(
                    modifier = Modifier.padding(horizontal = ItemSpacing),
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
                            .height(16.dp)
                            .weight(0.3F)
                            .shimmerEffect()
                    )

                    Spacer(modifier = Modifier.weight(0.1F))
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