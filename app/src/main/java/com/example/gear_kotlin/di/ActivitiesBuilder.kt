package com.example.gear_kotlin.di

import com.example.gear_kotlin.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesBuilder {
    /*
 * We modify our ActivityModule by adding the
 * FragmentModule to the Activity which contains
 * the fragment
 */
    @ContributesAndroidInjector(modules = [FragmentProvider::class, TestModule::class])
    abstract fun contributeMainActivity(): MainActivity


}