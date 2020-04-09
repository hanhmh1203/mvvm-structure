package com.example.gear_kotlin.di.module

import com.example.gear_kotlin.GearApplication
import com.example.local.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, DBModule::class, RepositoryModule::class, NetworkModule::class])
class AppModule {
    //db, network ..
    @Singleton
    @Provides
    fun provideDb(app: GearApplication): AppDatabase {
        return AppDatabase.buildDatabase(app)
    }
}