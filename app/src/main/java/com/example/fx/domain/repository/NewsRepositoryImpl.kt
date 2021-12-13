package com.example.fx.domain.repository

import android.util.Log
import com.example.fx.common.ApiResult
import com.example.fx.domain.data.remote.ForexApi

class NewsRepositoryImpl: INewsRepository {

    override suspend fun getNews(): ApiResult {
        Log.e("API: ", "return api")
        return ForexApi.httpGet("https://api.mitorg.net/mit-originalapps/htdocs/app/GetNewsTitles")
    }

}