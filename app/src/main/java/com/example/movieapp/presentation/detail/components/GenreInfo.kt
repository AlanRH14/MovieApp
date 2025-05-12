package com.example.movieapp.presentation.detail.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
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
        genreIds.forEachIndexed { index, genreText ->
            Text(
                modifier = Modifier
                    .padding(SmallPadding),
                text = genreText,
                maxLines = 1,
                style = MaterialTheme.typography.bodySmall
            )

            if (index < genreIds.lastIndex) {
                Text(
                    text = " \u2022 ",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }

        Spacer(modifier = Modifier.weight(1F))

        Text(
            text = runtime,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center
        )
    }
}