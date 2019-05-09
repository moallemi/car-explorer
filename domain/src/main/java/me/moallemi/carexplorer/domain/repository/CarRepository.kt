package me.moallemi.carexplorer.domain.repository

import io.reactivex.Single
import me.moallemi.carexplorer.domain.model.Car

interface CarRepository {

    fun getCars(): Single<List<Car>>
}