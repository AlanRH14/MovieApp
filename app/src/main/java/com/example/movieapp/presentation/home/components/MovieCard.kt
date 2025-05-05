package com.example.movieapp.presentation.home.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.ui.theme.ItemSpacing

@Composable
fun MovieCard(
    modifier: Modifier = Modifier,
    shape: CornerBasedShape = MaterialTheme.shapes.large,
    bgColor: Color = Color.Black.copy(alpha = 0.8F),
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier,
        shape = shape,
        colors = CardDefaults.cardColors(
            containerColor = bgColor,
            contentColor = Color.White,
        )
    ) {
        content()
    }
}

@Preview
@Composable
fun MovieCarPreview() {
    MovieCard {
        Text(
            modifier = Modifier
                .padding(all = ItemSpacing),
            text = "Action",
        )
    }
}