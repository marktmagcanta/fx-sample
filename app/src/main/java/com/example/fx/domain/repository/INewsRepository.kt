package com.example.fx.domain.repository

import com.example.fx.common.ApiResult

interface INewsRepository {
    suspend fun getNews(): ApiResult
}