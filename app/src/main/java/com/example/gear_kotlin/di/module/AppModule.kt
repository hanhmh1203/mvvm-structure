package com.example.gear_kotlin.di.module

import com.example.gear_kotlin.GearApplication
import com.example.local.AppDatabase
import com.example.commons.AppDispatchers
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, DBModule::class, RepositoryModule::class, NetworkModule::class])
class AppModule {
    //db, network ..
    @Singleton
    @Provides
    fun provideDb(app: GearApplication): AppDatabase {
        return AppDatabase.buildDatabase(app)
    }
    @Singleton
    @Provides
    fun provideAppdispatcher(): AppDispatchers {
        return AppDispatchers(
            Dispatchers.Main,
            Dispatchers.IO,
            Dispatchers.Default
        )
    }
}