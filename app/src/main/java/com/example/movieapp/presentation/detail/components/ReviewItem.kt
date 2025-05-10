package com.example.movieapp.presentation.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.movieapp.R
import com.example.movieapp.domain.models.movie_detail.Review
import com.example.movieapp.ui.theme.ItemSpacing
import kotlin.math.round

@Composable
fun ReviewItem(
    modifier: Modifier = Modifier,
    review: Review
) {

    Column(modifier = modifier) {
        val nameAnnotationString = buildAnnotatedString {
            append(review.author)
            append(" • ")
            append(review.createdAt)
        }

        val ratingAnnotationString = buildAnnotatedString {
            pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
            append(round(review.rating).toString())
            pop()

            pushStyle(SpanStyle(fontSize = 10.sp))
            append("10")
            pop()
        }

        Text(
            text = nameAnnotationString,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(ItemSpacing))

        CollapsibleText(
            text = review.content,
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(ItemSpacing))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = stringResource(id = R.string.rating_icon)
            )
            Text(
                text = ratingAnnotationString,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}