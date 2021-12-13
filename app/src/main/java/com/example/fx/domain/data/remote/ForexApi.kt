package com.example.fx.domain.data.remote

import android.util.Log
import com.example.fx.common.ApiResult
import com.example.fx.domain.data.remote.news.NewsDto
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.json.JSONObject
import org.json.JSONTokener
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.URL
import javax.net.ssl.HttpsURLConnection

/** Singleton object to handle http calls */
object ForexApi {

    fun httpGet(apiUrl: String): ApiResult {
        lateinit var urlConnection: HttpsURLConnection
        return try {
            val url = URL(apiUrl)
            urlConnection = url.openConnection() as HttpsURLConnection
            val stream = BufferedInputStream(urlConnection.inputStream)
            val response = stream.bufferedReader().use { it.readText() }
            val jsonR = Json.decodeFromString<NewsDto>(response)
            Log.e("JSON: ", "$jsonR")
            val jsonResponse = JSONTokener(response).nextValue() as JSONObject
            ApiResult.Success(jsonResponse)
        } catch (e: Exception) {
            ApiResult.Fail(e.message.toString())
        } finally {
            urlConnection.disconnect()
        }
    }

    private fun readStream(inputStream: BufferedInputStream): String {
        val reader = BufferedReader(InputStreamReader(inputStream))
        val result = StringBuilder()
        reader.forEachLine { result.append(it) }

        return result.toString()
    }

}