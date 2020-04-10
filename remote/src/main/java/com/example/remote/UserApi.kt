package com.example.remote

import com.example.model.ApiResult
import com.example.model.UserGit
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApi {
//
//    @GET("search/users")
//    fun fetchTopUsersAsync(@Query("q") query: String = "PhilippeB",
//                           @Query("sort") sort: String = "followers"): Deferred<ApiResult<UserGit>>
//
//    @GET("users/{login}")
//    fun fetchUserDetailsAsync(@Path("login") login: String): Deferred<UserGit>

    @GET("search/users")
    suspend fun fetchTopUsersAsync(@Query("q") query: String = "PhilippeB",
                           @Query("sort") sort: String = "followers"): ApiResult<UserGit>

    @GET("users/{login}")
    suspend fun fetchUserDetailsAsync(@Path("login") login: String): UserGit
}