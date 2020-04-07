package com.example.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.model.User

@Dao
interface UserDaoIn {
    @Query("SELECT * FROM User")
    fun getAll(): List<User>

    @Insert
    fun insert(vararg users: User)

    @Delete
    fun delete(user: User)
}