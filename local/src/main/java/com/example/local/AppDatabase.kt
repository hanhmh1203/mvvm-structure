package com.example.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.local.converter.Converters
import com.example.local.dao.UserDao
import com.example.local.dao.UserGitDao
import com.example.model.User
import com.example.model.UserGit

@Database(entities = [User::class, UserGit::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun userGitDao(): UserGitDao

    companion object {
        fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "gear_kotlin.db")
                .build()
    }
}