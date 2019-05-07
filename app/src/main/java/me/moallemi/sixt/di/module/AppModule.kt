package me.moallemi.sixt.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import me.moallemi.sixt.app.SixtApplication
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: SixtApplication): Context {
        return application.applicationContext
    }
}