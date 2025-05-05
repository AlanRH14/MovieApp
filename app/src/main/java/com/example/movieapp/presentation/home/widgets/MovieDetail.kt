package com.example.movieapp.presentation.home.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.movieapp.R
import com.example.movieapp.ui.theme.DefaultPadding
import com.example.movieapp.ui.theme.ItemSpacing
import com.example.movieapp.ui.theme.VerySmallPadding

@Composable
fun MovieDetail(
    modifier: Modifier = Modifier,
    rating: Double,
    title: String,
    genre: List<String>,
) {
    Column(
        modifier = Modifier
            .padding(all = DefaultPadding)
    ) {
        Row(
            modifier = Modifier
                .padding(all = VerySmallPadding),
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
        }
        Spacer(modifier = Modifier.height(ItemSpacing))
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            color = Color.White
        )
    }
}