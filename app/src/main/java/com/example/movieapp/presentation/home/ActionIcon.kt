package com.example.movieapp.presentation.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.graphics.vector.ImageVector

enum class ActionIcon(val icon: ImageVector, val contentDescription: String) {
    BookMark(icon = Icons.Default.Bookmark, contentDescription = "bookmark"),
    Share(icon = Icons.Default.Share, contentDescription = "Share"),
    Download(icon = Icons.Default.Download, contentDescription = "Download")
}