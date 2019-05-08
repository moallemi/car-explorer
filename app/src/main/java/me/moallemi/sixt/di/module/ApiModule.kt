package me.moallemi.sixt.di.module

import dagger.Module
import dagger.Provides
import me.moallemi.sixt.remote.api.CarService
import me.moallemi.sixt.di.scope.NetworkScope
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    @NetworkScope
    fun provideCarServiceApi(retrofit: Retrofit): CarService {
        return retrofit.create(CarService::class.java)
    }
}