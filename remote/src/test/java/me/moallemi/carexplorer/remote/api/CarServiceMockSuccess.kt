package me.moallemi.carexplorer.remote.api

import io.reactivex.Single
import me.moallemi.carexplorer.remote.datasource.CarFactory
import me.moallemi.carexplorer.remote.dto.CarDto
import retrofit2.mock.BehaviorDelegate

class CarServiceMockSuccess(private val delegate: BehaviorDelegate<CarService>) : CarService {

    override fun getCars(): Single<List<CarDto>> {
        val carDto = CarFactory.createCarDto()
        return delegate.returningResponse(listOf(carDto)).getCars()
    }
}