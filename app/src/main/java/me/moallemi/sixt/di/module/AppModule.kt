package me.moallemi.sixt.di.module

import android.content.Context
import me.moallemi.sixt.app.executer.BackgroundThread
import me.moallemi.sixt.app.executer.MainThread
import dagger.Module
import dagger.Provides
import me.moallemi.sixt.app.SixtApplication
import me.moallemi.sixt.di.scope.AppScope
import me.moallemi.sixt.domain.executor.PostExecutionThread
import me.moallemi.sixt.domain.executor.UseCaseExecutorThread

@Module
class AppModule {

    @Provides
    @AppScope
    fun provideContext(application: SixtApplication): Context {
        return application.applicationContext
    }

    @Provides
    @AppScope
    fun provideUseCaseExecutor(): UseCaseExecutorThread = MainThread()

    @Provides
    @AppScope
    fun providePostExecutionThread(): PostExecutionThread = BackgroundThread()
}