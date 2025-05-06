package com.example.movieapp.data.remote.models.movie_detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("author")
    val author: String? = null,
    @SerialName("author_details")
    val authorDetails: AuthorDetails? = null,
    @SerialName("content")
    val content: String? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("updated_at")
    val updatedAt: String? = null,
    @SerialName("url")
    val url: String? = null
)