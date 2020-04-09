package com.example.remote

import com.example.model.RedditNewsResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call

interface NewsApi{
    fun getNewsOldApi(after: String, limit: String): Call<RedditNewsResponse>
    suspend fun getNews(after: String, limit: String): Deferred<RedditNewsResponse>
}