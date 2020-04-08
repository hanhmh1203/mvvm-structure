package com.example.gear_kotlin.di

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
class TestModule {

    @Provides
    fun contributeService(): TestService{
        return TestService()
    }
}