package com.example.gear_kotlin.di.module

import com.example.gear_kotlin.GearApplication
import com.example.local.AppDatabase
import com.example.local.dao.UserDao
import com.example.local.dao.UserGitDao
import com.example.remote.UserApi
import com.example.remote.UserDataSource
import com.example.repository.UserGitRepository
import com.example.repository.UserGitRepositoryImpl
import com.example.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module()
class DBModule {

    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase): UserDao {
        return db.userDao()
    }
    @Singleton
    @Provides
    fun provideUserGitDao(db: AppDatabase): UserGitDao {
        return db.userGitDao()
    }

    @Singleton
    @Provides
    fun provideUserDataSource(userApi: UserApi): UserDataSource {
        return UserDataSource(userApi)
    }

}