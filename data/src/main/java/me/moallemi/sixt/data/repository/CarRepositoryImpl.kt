package me.moallemi.sixt.data.repository

import io.reactivex.Single
import me.moallemi.sixt.data.datasource.CarRemoteDataSource
import me.moallemi.sixt.data.entity.toCar
import me.moallemi.sixt.domain.model.Car
import me.moallemi.sixt.domain.repository.CarRepository
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(private val carRemoteDataSource: CarRemoteDataSource) : CarRepository {

    override fun getCars(): Single<List<Car>> {
        return carRemoteDataSource.getCars().map { carsList ->
            carsList.map { carEntity ->
                carEntity.toCar()
            }
        }
    }
}