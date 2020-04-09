package com.example.gear_kotlin

import com.example.gear_kotlin.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


class GearApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        appComponent.inject(this)

        return appComponent
    }

    override fun onCreate() {
        super.onCreate()
    }
}