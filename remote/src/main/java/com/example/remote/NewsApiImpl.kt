package com.example.remote

import com.example.model.RedditNewsResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import javax.inject.Inject
class NewsApiImpl @Inject constructor(private val redditApi: RedditApi) : NewsApi{
    override fun getNewsOldApi(after: String, limit: String): Call<RedditNewsResponse> {
        return redditApi.getTop(after, limit)
    }

    override suspend fun getNews(after: String, limit: String): Deferred<RedditNewsResponse> {
        return redditApi.getDeferredTop(after, limit)
    }

}