package com.example.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.local.dao.UserGitDao
import com.example.model.ApiResult
import com.example.model.UserGit
import com.example.remote.UserDataSource
import com.example.repository.utils.NetworkBoundResource
import com.example.repository.utils.NetworkBoundResourceNoDB
import com.example.repository.utils.Resource
import javax.inject.Inject


class UserGitRepositoryImpl @Inject constructor(
    private val dataSource: UserDataSource,
    private val dao: UserGitDao
) : UserGitRepository {

    /**
     * Suspended function that will get a list of top [User]
     * whether in cache (SQLite) or via network (API).
     * [NetworkBoundResource] is responsible to handle this behavior.
     */
    override suspend fun getTopUsersWithCache(forceRefresh: Boolean): LiveData<Resource<List<UserGit>>> {
        return object : NetworkBoundResource<List<UserGit>, ApiResult<UserGit>>() {

            override fun processResponse(response: ApiResult<UserGit>): List<UserGit> =
                response.items

            override suspend fun saveCallResults(items: List<UserGit>) = dao.save(items)

            override fun shouldFetch(data: List<UserGit>?): Boolean =
                data == null || data.isEmpty() || forceRefresh

            override suspend fun loadFromDb(): List<UserGit> = dao.getTopUsers()

            override suspend fun createCallAsync(): ApiResult<UserGit> =
                dataSource.fetchTopUsersAsync()

        }.build().asLiveData()

    }

    /**
     * Suspended function that will get a list of top [User]
     * whether in cache (SQLite) or via network (API).
     * [NetworkBoundResource] is responsible to handle this behavior.
     */
    override suspend fun getTopUsersWithCacheNoDB(): LiveData<Resource<List<UserGit>>> {
        return object : NetworkBoundResourceNoDB<List<UserGit>, ApiResult<UserGit>>() {
            override fun processResponse(response: ApiResult<UserGit>): List<UserGit> =
                response.items

            override suspend fun createCallAsync(): ApiResult<UserGit> =
                dataSource.fetchTopUsersAsync()

        }.build().asLiveData()

//        var result = MutableLiveData<Resource<List<UserGit>>>()
//        result.postValue( Resource.success(dataSource.fetchTopUsersAsync().items))
//        return result

    }


    /**
     * Suspended function that will get details of a [User]
     * whether in cache (SQLite) or via network (API).
     * [NetworkBoundResource] is responsible to handle this behavior.
     */
    override suspend fun getUserDetailWithCache(
        forceRefresh: Boolean,
        login: String
    ): LiveData<Resource<UserGit>> {
        return object : NetworkBoundResource<UserGit, UserGit>() {

            override fun processResponse(response: UserGit): UserGit = response

            override suspend fun saveCallResults(item: UserGit) = dao.save(item)

            override fun shouldFetch(data: UserGit?): Boolean = data == null
                    || data.haveToRefreshFromNetwork()
                    || data.name.isNullOrEmpty()
                    || forceRefresh

            override suspend fun loadFromDb(): UserGit = dao.getUser(login)

            override suspend fun createCallAsync(): UserGit =
                dataSource.fetchUserDetailsAsync(login)

        }.build().asLiveData()
    }
}