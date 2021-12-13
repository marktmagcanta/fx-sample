package com.example.fx.domain.use_case

import android.util.Log
import com.example.fx.common.ApiResult
import com.example.fx.common.ApiState
import com.example.fx.domain.data.remote.news.NewsDetailDto
import com.example.fx.domain.repository.INewsRepository
import com.example.fx.domain.repository.NewsRepositoryImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetNewsUseCase {
    private val repository: INewsRepository = NewsRepositoryImpl()

//    suspend fun getNewsList(): Flow<ApiState<List<NewsDetailDto>>> = flow {
//        Log.e("FLOW: ", "LOADING")
//        emit(ApiState.Loading(null))
//        val newsApiResponse = repository.getNews()
//        when(newsApiResponse) {
//            is ApiResult.Success -> {
//                //Process result
//                val data = listOf<NewsDetailDto>()
//                emit(ApiState.Success(data))
//            }
//            is ApiResult.Fail -> {
//                //return error
//                emit(ApiState.Fail(newsApiResponse.error))
//            }
//        }
//    }
    suspend fun getNewsList(): ApiState<String> {
        val newsApiResponse = repository.getNews()
        when(newsApiResponse) {
            is ApiResult.Success-> {
                return ApiState.Success(newsApiResponse.response.toString())
            }
            is ApiResult.Fail -> {
                return ApiState.Fail(newsApiResponse.error)
            }
        }
    }
}