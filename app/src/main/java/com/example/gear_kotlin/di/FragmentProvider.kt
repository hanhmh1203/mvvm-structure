package com.example.gear_kotlin.di

import com.example.gear_kotlin.ui.AppFirstFragment
import com.example.gear_kotlin.ui.AppSecondFragment
import com.example.gear_kotlin.ui.ThirdFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
public abstract class FragmentProvider {
    @ContributesAndroidInjector()
    abstract fun contributeThirdFragment(): ThirdFragment

    @ContributesAndroidInjector
    abstract fun contribute1Fragment(): AppFirstFragment

    @ContributesAndroidInjector
    abstract fun contribute2Fragment(): AppSecondFragment
}