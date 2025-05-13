package com.example.movieapp.presentation.detail.components.shimmer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.movieapp.presentation.components.shimmer.shimmerEffect
import com.example.movieapp.ui.theme.ItemSpacing
import com.example.movieapp.ui.theme.VerySmallPadding

@Composable
fun ActorItemShimmer() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        repeat(8) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
                        .height(12.dp)
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
}