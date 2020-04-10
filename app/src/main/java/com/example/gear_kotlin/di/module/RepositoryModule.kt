package com.example.gear_kotlin.di.module

import com.example.gear_kotlin.GearApplication
import com.example.local.AppDatabase
import com.example.local.dao.UserDao
import com.example.local.dao.UserGitDao
import com.example.remote.UserDataSource
import com.example.repository.UserGitRepository
import com.example.repository.UserGitRepositoryImpl
import com.example.repository.UserRepository
import dagger.Module
import dagger.Provides
import io.philippeboisney.home.domain.GetTopUsersUseCase
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
    fun provideGetTopUserCase(userGitRepository: UserGitRepository): GetTopUsersUseCase {
        return GetTopUsersUseCase(userGitRepository)
    }

    @Singleton
    @Provides
    fun provideUserGitRepository(userGitDao: UserGitDao, dataSource: UserDataSource): UserGitRepository {
        return UserGitRepositoryImpl(dataSource, userGitDao)
    }

}