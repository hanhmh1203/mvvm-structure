package com.example.local.dao

import androidx.room.*

interface  BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(obs: List<T>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(obj: T)

    @Update
    abstract suspend fun update(obj: T)

    @Delete
    abstract suspend fun delete(obj: T)

}