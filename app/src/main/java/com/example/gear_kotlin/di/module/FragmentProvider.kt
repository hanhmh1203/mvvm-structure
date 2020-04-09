package com.example.gear_kotlin.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gear_kotlin.ui.AppFirstFragment
import com.example.gear_kotlin.ui.AppSecondFragment
import com.example.gear_kotlin.ui.ThirdFragment
import com.example.gear_kotlin.viewmodel.ThirdFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module()
public abstract class FragmentProvider {
    @ContributesAndroidInjector()
    abstract fun contributeThirdFragment(): ThirdFragment


    @ContributesAndroidInjector
    abstract fun contribute1Fragment(): AppFirstFragment

    @ContributesAndroidInjector
    abstract fun contribute2Fragment(): AppSecondFragment
}