package com.example.movieapp.presentation.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.movieapp.ui.theme.VerySmallPadding

@Composable
fun MovieInfoItem(
    infoItem: List<String>,
    title: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.width(VerySmallPadding))

        LazyRow(
            verticalAlignment = Alignment.CenterVertically
        ) {
            itemsIndexed(infoItem) { index, info ->
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = info,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold
                )

                if (index < infoItem.lastIndex) {
                    Text(
                        text = " \u2022 ",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}