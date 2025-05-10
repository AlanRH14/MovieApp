package com.example.movieapp.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieapp.utils.Keys.BASE_IMAGE_URL

@Composable
fun GenericImage(
    modifier: Modifier = Modifier,
    pathImage: String,
    contentDescription: String,
    placeholder: Painter? = null,
) {

    val imgRequest = ImageRequest.Builder(LocalContext.current)
        .data("$BASE_IMAGE_URL$pathImage")
        .crossfade(true)
        .build()

    AsyncImage(
        modifier = modifier,
        model = imgRequest,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        onError = {
            it.result.throwable.printStackTrace()
        },
        placeholder = placeholder,
    )
}