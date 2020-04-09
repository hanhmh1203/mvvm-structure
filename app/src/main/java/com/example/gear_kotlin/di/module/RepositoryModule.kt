package com.example.gear_kotlin.di.module

import com.example.gear_kotlin.GearApplication
import com.example.local.AppDatabase
import com.example.local.dao.UserDao
import com.example.remote.NewsApi
import com.example.repository.NewsRepository
import com.example.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module()
class RepositoryModule {
    @Singleton
    @Provides
    fun provideUserRepository(userDao: UserDao): UserRepository {
        return UserRepository(userDao)
    }

    @Singleton
    @Provides
    fun provideNewsRepository(api: NewsApi): NewsRepository {
        return NewsRepository(api)
    }
}