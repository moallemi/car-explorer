package me.moallemi.sixt.di.component

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import me.moallemi.sixt.app.SixtApplication
import me.moallemi.sixt.di.module.ApiModule
import me.moallemi.sixt.di.module.AppModule
import me.moallemi.sixt.di.module.NetworkModule
import me.moallemi.sixt.di.scope.AppScope

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApiModule::class,
        AppModule::class,
        NetworkModule::class
    ]
)
@AppScope
interface AppComponent : AndroidInjector<SixtApplication> {
    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<SixtApplication>
}