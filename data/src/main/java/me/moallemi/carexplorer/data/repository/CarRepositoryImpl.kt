package me.moallemi.carexplorer.data.repository

import io.reactivex.Single
import me.moallemi.carexplorer.data.datasource.CarRemoteDataSource
import me.moallemi.carexplorer.data.entity.toCar
import me.moallemi.carexplorer.domain.model.Car
import me.moallemi.carexplorer.domain.repository.CarRepository
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