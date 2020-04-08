package com.example.gear_kotlin.di

import com.example.gear_kotlin.GearApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton


@Component(
    modules = [AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivitiesBuilder::class
    ]

)
@Singleton
interface AppComponent : AndroidInjector<DaggerApplication> {
    /*
        * This is our custom Application class
        * */
    fun inject(gearApplication: GearApplication)

    /*
     * We will call this builder interface from our custom Application class.
     * This will set our application object to the AppComponent.
     * So inside the AppComponent the application instance is available.
     * So this application instance can be accessed by our modules
     * such as ApiModule when needed
     *
     * */
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: GearApplication): Builder
        fun build(): AppComponent
    }


}