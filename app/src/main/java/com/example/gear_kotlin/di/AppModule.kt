package com.example.gear_kotlin.di

import android.app.Application
import androidx.room.Room
import com.example.gear_kotlin.GearApplication
import com.example.local.AppDatabase
import com.example.local.dao.UserDao
import com.example.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
    //db, network ..
    @Singleton
    @Provides
    fun provideDb(app: GearApplication): AppDatabase {
        return AppDatabase.buildDatabase(app)
    }
    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase): UserDao {
        return db.userDao()
    }

    @Singleton
    @Provides
    fun provideUserRepository(userDao: UserDao): UserRepository {
        return UserRepository(userDao)
    }
}