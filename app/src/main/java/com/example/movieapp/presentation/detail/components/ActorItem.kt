package com.example.movieapp.presentation.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.movieapp.R
import com.example.movieapp.domain.models.movie_detail.Cast
import com.example.movieapp.presentation.components.GenericImage
import com.example.movieapp.ui.theme.VerySmallPadding

@Composable
fun ActorItem(
    modifier: Modifier = Modifier,
    cast: Cast
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GenericImage(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape),
            pathImage = cast.profilePath,
            contentDescription = stringResource(R.string.cast_image),
            placeholder = painterResource(R.drawable.ic_person)
        )

        Text(
            text = cast.genderRole,
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(VerySmallPadding))

        Text(
            text = cast.fistName,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = cast.lastName,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
    }
}