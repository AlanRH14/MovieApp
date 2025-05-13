package com.example.movieapp.presentation.detail.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.ui.theme.ItemSpacing
import com.example.movieapp.ui.theme.SmallPadding

@Composable
fun GenreInfo(
    genreIds: List<String> = emptyList(),
    runtime: String = ""
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier = Modifier
                .padding(SmallPadding)
                .weight(1F),
            verticalAlignment = Alignment.CenterVertically
        ) {
            genreIds.forEachIndexed { index, genreText ->
                Text(
                    text = genreText,
                    maxLines = 1,
                    style = MaterialTheme.typography.bodySmall
                )

                if (index < genreIds.lastIndex) {
                    Text(
                        modifier = Modifier.padding(horizontal = ItemSpacing),
                        text = " \u2022 ",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }

        Text(
            text = runtime,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GenreInfoPreview() {
    GenreInfo(
        genreIds = listOf("Horror", "Fantasy", "Comedy", "Adventure", "Science Fiction"),
        runtime = "1h:47m"
    )
}

@Preview(showBackground = true)
@Composable
fun GenreInfoPreview2() {
    GenreInfo(
        genreIds = listOf("Horror", "Fantasy"),
        runtime = "1h:47m"
    )
}