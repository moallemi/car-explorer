package me.moallemi.carexplorer.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import me.moallemi.carexplorer.app.CarExplorerApp
import me.moallemi.carexplorer.app.executer.BackgroundThread
import me.moallemi.carexplorer.app.executer.MainThread
import me.moallemi.carexplorer.di.scope.AppScope
import me.moallemi.carexplorer.domain.executor.PostExecutionThread
import me.moallemi.carexplorer.domain.executor.UseCaseExecutorThread

@Module
class AppModule {

    @Provides
    @AppScope
    fun provideContext(application: CarExplorerApp): Context {
        return application.applicationContext
    }

    @Provides
    @AppScope
    fun provideUseCaseExecutor(): UseCaseExecutorThread = BackgroundThread()

    @Provides
    @AppScope
    fun providePostExecutionThread(): PostExecutionThread = MainThread()
}