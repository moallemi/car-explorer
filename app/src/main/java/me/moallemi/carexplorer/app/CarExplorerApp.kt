package me.moallemi.carexplorer.app

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import me.moallemi.carexplorer.di.component.DaggerAppComponent

class CarExplorerApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}