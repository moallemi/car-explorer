package me.moallemi.carexplorer.remote.datasource

import io.reactivex.Single
import me.moallemi.carexplorer.data.datasource.CarRemoteDataSource
import me.moallemi.carexplorer.data.entity.CarEntity
import me.moallemi.carexplorer.remote.api.CarService
import me.moallemi.carexplorer.remote.dto.toCarEntity
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