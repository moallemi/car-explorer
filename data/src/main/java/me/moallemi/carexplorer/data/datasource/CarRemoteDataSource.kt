package me.moallemi.carexplorer.data.datasource

import io.reactivex.Single
import me.moallemi.carexplorer.data.entity.CarEntity

interface CarRemoteDataSource {

    fun getCars(): Single<List<CarEntity>>
}