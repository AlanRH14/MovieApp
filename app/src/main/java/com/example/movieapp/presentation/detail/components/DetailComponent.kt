package com.example.movieapp.presentation.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.movieapp.R
import com.example.movieapp.presentation.home.components.MovieCard
import com.example.movieapp.ui.theme.DefaultPadding
import com.example.movieapp.ui.theme.ItemSpacing
import com.example.movieapp.ui.theme.SmallPadding
import com.example.movieapp.ui.theme.VerySmallPadding

@Composable
fun DetailComponent(
    modifier: Modifier = Modifier,
    rating: Double,
    releaseDate: String,
) {
    Column(modifier = modifier) {
        MovieCard(
            modifier = Modifier
                .padding(horizontal = DefaultPadding)
        ) {
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

                Text(
                    modifier = Modifier
                        .padding(SmallPadding)
                        .weight(0.6F),
                    textAlign = TextAlign.Center,
                    text = releaseDate,
                )
            }
        }
    }
}