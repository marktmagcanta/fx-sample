package com.example.fx.common

import org.json.JSONObject

sealed class ApiResult {
    data class Success(val response: JSONObject) : ApiResult()
    data class Fail(val error: String) : ApiResult()
}
