package com.example.movieapp.presentation.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.R
import com.example.movieapp.presentation.home.components.MovieCard
import com.example.movieapp.ui.theme.ItemSpacing
import com.example.movieapp.ui.theme.SmallPadding
import com.example.movieapp.ui.theme.VerySmallPadding
import com.example.movieapp.ui.theme.primaryLightHighContrast

@Composable
fun DetailComponent(
    modifier: Modifier = Modifier,
    rating: Double,
    releaseDate: String,
) {
    Column(modifier = modifier) {
        MovieCard {
            Row(
                modifier = Modifier.padding(all = VerySmallPadding),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = stringResource(R.string.rating_icon),
                    tint = Color.Yellow
                )

                Spacer(modifier = Modifier.width(VerySmallPadding))

                Text(text = rating.toString())

                Spacer(modifier = Modifier.width(ItemSpacing))

                VerticalDivider(
                    modifier = Modifier.height(16.dp),
                    thickness = 2.dp
                )

                Spacer(modifier = Modifier.width(ItemSpacing))

                Text(
                    modifier = Modifier
                        .padding(SmallPadding),
                    text = releaseDate,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                )
            }
        }

        Spacer(modifier = Modifier.height(ItemSpacing))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .weight(1F),
                onClick = {},
                shape = RoundedCornerShape(
                    topStart = 30.dp,
                    bottomStart = 30.dp
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(all = VerySmallPadding),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.PlayArrow,
                        contentDescription = stringResource(R.string.play_arrow_icon),
                    )

                    Spacer(modifier = Modifier.width(VerySmallPadding))

                    Text(text = "Watch Now")
                }
            }

            Card(
                modifier = Modifier
                    .weight(1F),
                onClick = {},
                colors = CardDefaults.cardColors(
                    contentColor = primaryLightHighContrast,
                    containerColor = Color.White,
                ),
                shape = RoundedCornerShape(
                    topEnd = 30.dp,
                    bottomEnd = 30.dp
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(all = VerySmallPadding),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.PlayArrow,
                        contentDescription = ""
                    )

                    Spacer(modifier = Modifier.width(VerySmallPadding))

                    Text("Watch Trailer")
                }
            }
        }
    }
}

@Preview
@Composable
private fun DetailComponentPreview() {
    DetailComponent(
        rating = 3.14,
        releaseDate = "2024-10-22"
    )
}