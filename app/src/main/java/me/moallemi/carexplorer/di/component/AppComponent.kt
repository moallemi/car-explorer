package me.moallemi.carexplorer.di.component

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import me.moallemi.carexplorer.app.CarExplorerApp
import me.moallemi.carexplorer.di.module.ApiModule
import me.moallemi.carexplorer.di.module.AppModule
import me.moallemi.carexplorer.di.module.BrowseModule
import me.moallemi.carexplorer.di.module.NetworkModule
import me.moallemi.carexplorer.di.module.ViewModelFactoryModule
import me.moallemi.carexplorer.di.scope.AppScope

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApiModule::class,
        AppModule::class,
        BrowseModule::class,
        NetworkModule::class,
        ViewModelFactoryModule::class
    ]
)
@AppScope
interface AppComponent : AndroidInjector<CarExplorerApp> {
    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<CarExplorerApp>
}