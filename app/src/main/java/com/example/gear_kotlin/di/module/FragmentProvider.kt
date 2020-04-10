package com.example.gear_kotlin.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.example.gear_kotlin.di.ViewModelKey
import com.example.gear_kotlin.network.HomeFragment
import com.example.gear_kotlin.ui.AppFirstFragment
import com.example.gear_kotlin.ui.AppSecondFragment
import com.example.gear_kotlin.ui.ThirdFragment
import com.example.gear_kotlin.viewmodel.ThirdFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module()
public abstract class FragmentProvider {
    @ContributesAndroidInjector()
    abstract fun contributeThirdFragment(): ThirdFragment

    @ContributesAndroidInjector
    abstract fun contribute1Fragment(): AppFirstFragment

    @ContributesAndroidInjector
    abstract fun contribute2Fragment(): AppSecondFragment


    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment
}