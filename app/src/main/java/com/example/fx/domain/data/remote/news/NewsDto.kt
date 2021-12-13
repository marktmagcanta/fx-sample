package com.example.fx.domain.data.remote.news

import kotlinx.serialization.Serializable

@Serializable
data class NewsDto(
    val message: String,
    val newsList: List<NewsDetailDto>,
    val result: Int,
    val status: Int,
    val systemDateTime: String
)