package com.example.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.model.User
import kotlinx.coroutines.flow.Flow

@Dao
abstract class UserDao: BaseDao<User> {

    @Query("SELECT * FROM User")
    abstract suspend fun getAll(): List<User>

    @Query("SELECT * FROM User")
    abstract fun getAllByFlow(): Flow<List<User>>

    @Insert
    abstract suspend fun insert(vararg users: User)

    @Query("DELETE FROM User")
    abstract suspend fun deleteAll()
}