package me.moallemi.sixt.domain.repository

import io.reactivex.Single
import me.moallemi.sixt.domain.model.Car

interface CarRepository {

    fun getCars(): Single<List<Car>>
}