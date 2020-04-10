package com.example.repository

import androidx.lifecycle.LiveData
import com.example.model.UserGit
import com.example.repository.utils.Resource

interface UserGitRepository {
    suspend fun getTopUsersWithCache(forceRefresh: Boolean = true): LiveData<Resource<List<UserGit>>>
    suspend fun getUserDetailWithCache(forceRefresh: Boolean = true, login: String): LiveData<Resource<UserGit>>
}
