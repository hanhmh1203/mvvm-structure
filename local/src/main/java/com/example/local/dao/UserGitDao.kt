package com.example.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.model.UserGit
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
abstract class UserGitDao: BaseDao<UserGit> {

    @Query("SELECT * FROM UserGit ORDER BY login ASC LIMIT 30")
    abstract suspend fun getTopUsers(): List<UserGit>

    @Query("SELECT * FROM UserGit WHERE login = :login LIMIT 1")
    abstract suspend fun getUser(login: String): UserGit

    // ---

    // ---


    /**
     * Each time we save an user, we update its 'lastRefreshed' field
     * This allows us to know when we have to refresh its data
     */

    suspend fun save(user: UserGit) {
        insert(user.apply { lastRefreshed = Date() })
    }

    suspend fun save(users: List<UserGit>) {
        insert(users.apply { forEach { it.lastRefreshed = Date() } })
    }
}