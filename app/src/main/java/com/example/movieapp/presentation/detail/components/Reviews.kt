package com.example.movieapp.presentation.detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.movieapp.R
import com.example.movieapp.domain.models.movie_detail.Review
import com.example.movieapp.ui.theme.ItemSpacing

@Composable
fun Reviews(
    modifier: Modifier = Modifier,
    reviews: List<Review>
) {
    val (viewMore, setViewMore) = remember {
        mutableStateOf(false)
    }
    val defaultReview = if (reviews.size > 3) {
        reviews.take(3)
    } else {
        reviews
    }
    val movieReviews = if (viewMore) {
        reviews
    } else {
        defaultReview
    }
    val btnText = if (viewMore) {
        stringResource(R.string.btn_collapse_reviews)
    } else {
        stringResource(R.string.btn_more_reviews)
    }

    Column {
        movieReviews.forEach { review ->
            ReviewItem(review = review)

            Spacer(modifier = Modifier.height(ItemSpacing))

            HorizontalDivider(modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(ItemSpacing))
        }

        TextButton(
            onClick = { setViewMore(!viewMore) }
        ) {
            Text(text = btnText)
        }
    }
}