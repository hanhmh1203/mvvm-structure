package com.example.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.model.User

@Dao
abstract class UserDao: BaseDao<User>() {
    override suspend fun insert(users: List<User>) {
        TODO("Not yet implemented")
    }

    override suspend fun insert(user: User) {
        TODO("Not yet implemented")
    }
    @Query("SELECT * FROM User")
    abstract fun getAll(): List<User>

    @Insert
    abstract fun insertAll(vararg users: User)

    @Delete
    abstract fun delete(user: User)
}