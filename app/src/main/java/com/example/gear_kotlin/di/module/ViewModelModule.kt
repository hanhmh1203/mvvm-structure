package com.example.gear_kotlin.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gear_kotlin.di.DaggerViewModelFactory
import com.example.gear_kotlin.di.ViewModelKey
import com.example.gear_kotlin.viewmodel.ThirdFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory

    @Singleton
    @Binds
    @IntoMap
    @ViewModelKey(ThirdFragmentViewModel::class)
    abstract fun thirdFragmentViewModel(model: ThirdFragmentViewModel): ViewModel


}