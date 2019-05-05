package me.moallemi.sixt.data.datasource

import io.reactivex.Single
import me.moallemi.sixt.data.entity.CarEntity

interface CarRemoteDataSource {

    fun getLatestCars(): Single<List<CarEntity>>
}