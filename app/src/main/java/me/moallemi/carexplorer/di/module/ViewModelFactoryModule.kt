package me.moallemi.carexplorer.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import me.moallemi.carexplorer.app.ViewModelFactory

@Module
abstract class ViewModelFactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}