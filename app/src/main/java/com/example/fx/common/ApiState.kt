package com.example.fx.common

//sealed class ApiState<T>(open val data: T? = null, open val exception: String? = null){
//    data class Loading<T>(override val data: T?  = null): ApiState<T>(data)
//    data class Success<T>(override val data: T) : ApiState<T>(data)
//    data class Fail<T>(override val exception: String, override val data: T? = null): ApiState<T>(data, exception)
//}

sealed class ApiState<T> {
    data class Success<T>(val data: String) : ApiState<T>()
    data class Fail<T>(val exception: String): ApiState<T>()
}

//
//val ApiState<*>.succeeded
//    get() = this is Success && data!= null
//
//fun <T> ApiState<T>.successOr(fallback: T): T {
//    return (this as? Success<T>)?.data ?: fallback
//}