package com.example.repository


import androidx.lifecycle.LiveData
import com.example.model.RedditDataResponse
import com.example.model.RedditNewsResponse
import com.example.remote.NewsApi
import kotlinx.coroutines.Deferred
import javax.inject.Inject

class NewsRepository @Inject constructor( var newApi: NewsApi) {
    suspend fun getNewsOldApi(after: String, limit: String): RedditNewsResponse {
       return newApi.getNews(after, limit).await()
    }

//    suspend fun getNews(after: String, limit: String): RedditNewsResponse {
////        return newApi.getNewsOldApi(after, limit).execute()!!.body()!!
//        return RedditNewsResponse(RedditDataResponse())
//    }

}