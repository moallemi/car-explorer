package me.moallemi.sixt.app

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import me.moallemi.sixt.di.component.DaggerAppComponent

class SixtApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}