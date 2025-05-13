package com.example.movieapp.presentation.components.shimmer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieapp.ui.theme.ItemSpacing

@Composable
fun HeaderMovieListShimmer() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = ItemSpacing),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth()
                .shimmerEffect()
                .weight(1F)
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
        )

        Box(
            modifier = Modifier
                .size(24.dp)
                .shimmerEffect()
        )
    }
}