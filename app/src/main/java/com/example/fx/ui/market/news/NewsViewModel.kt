package com.example.fx.ui.market.news

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.fx.common.ApiState
import com.example.fx.domain.use_case.GetNewsUseCase
import kotlinx.coroutines.flow.onEach

class NewsViewModel : ViewModel() {

    private val getNewsUseCase = GetNewsUseCase()

    suspend fun getNews() {
        val apiState = getNewsUseCase.getNewsList()
        when(apiState) {
            is ApiState.Success -> {
                Log.e("STATE: ", "${apiState.data}")
            }
            is ApiState.Fail -> {
                Log.e("STATE: ", "SUCCESS")
            }
        }
    }
}