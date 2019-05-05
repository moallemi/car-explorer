package me.moallemi.sixt.remote.datasource

import io.reactivex.Single
import me.moallemi.sixt.data.datasource.CarRemoteDataSource
import me.moallemi.sixt.data.entity.CarEntity
import me.moallemi.sixt.remote.api.CarService
import me.moallemi.sixt.remote.dto.toCarEntity
import javax.inject.Inject

class CarRemoteDataSourceImpl @Inject constructor(private val carService: CarService) : CarRemoteDataSource {

    override fun getCars(): Single<List<CarEntity>> {
        return carService.getCars()
            .map { carsList ->
                carsList.map { carDto ->
                    carDto.toCarEntity()
                }
            }
    }
}