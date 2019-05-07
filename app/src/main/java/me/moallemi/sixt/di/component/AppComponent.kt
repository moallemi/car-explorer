package me.moallemi.sixt.di.component

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import me.moallemi.sixt.app.SixtApplication
import me.moallemi.sixt.di.module.AppModule

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<SixtApplication> {
    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<SixtApplication>
}