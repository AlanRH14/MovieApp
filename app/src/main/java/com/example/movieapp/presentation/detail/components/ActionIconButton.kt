package com.example.movieapp.presentation.detail.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.movieapp.presentation.home.components.MovieCard
import com.example.movieapp.ui.theme.VerySmallPadding

@Composable
fun ActionIconButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    contentDescription: String? = null,
    bgColor: Color = Color.Black.copy(0.8F)
) {
    MovieCard(
        modifier = modifier
            .padding(all = VerySmallPadding),
        shape = CircleShape
    ) {
        Icon(
            modifier = Modifier.padding(VerySmallPadding),
            imageVector = icon,
            contentDescription = contentDescription,
            tint = bgColor
        )
    }
}