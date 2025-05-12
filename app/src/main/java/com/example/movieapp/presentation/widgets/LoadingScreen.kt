package com.example.movieapp.presentation.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier,
    isLoading: Boolean
) {
    AnimatedVisibility(
        visible = isLoading,
        enter = fadeIn() + expandVertically()
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3F)
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                )
            }
        }
    }
}
