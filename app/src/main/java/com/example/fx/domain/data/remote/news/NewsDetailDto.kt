package com.example.fx.domain.data.remote.news

import kotlinx.serialization.Serializable

@Serializable
data class NewsDetailDto(
    val dataDate: String,
    val genreCode: String,
    val genreCode2: String,
    val newsId: String,
    val receivedDate: String,
    val title: String
)