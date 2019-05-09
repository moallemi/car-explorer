package me.moallemi.carexplorer.di.module

import dagger.Module
import dagger.Provides
import me.moallemi.carexplorer.di.scope.AppScope
import me.moallemi.carexplorer.remote.api.CarService
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    @AppScope
    fun provideCarServiceApi(retrofit: Retrofit): CarService {
        return retrofit.create(CarService::class.java)
    }
}