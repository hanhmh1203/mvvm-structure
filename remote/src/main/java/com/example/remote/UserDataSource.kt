package com.example.remote

import javax.inject.Inject

/**
 * Implementation of [UserApi] interface
 */
class UserDataSource @Inject constructor(private val userApi: UserApi) {

    suspend fun fetchTopUsersAsync() =
        userApi.fetchTopUsersAsync()

    suspend fun fetchUserDetailsAsync(login: String) =
        userApi.fetchUserDetailsAsync(login)
}