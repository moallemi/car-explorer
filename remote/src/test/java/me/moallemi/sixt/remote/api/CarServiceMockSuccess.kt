package me.moallemi.sixt.remote.api

import io.reactivex.Single
import me.moallemi.sixt.remote.datasource.CarFactory
import me.moallemi.sixt.remote.dto.CarDto
import retrofit2.mock.BehaviorDelegate

class CarServiceMockSuccess(private val delegate: BehaviorDelegate<CarService>) : CarService {

    override fun getCars(): Single<List<CarDto>> {
        val carDto = CarFactory.createCarDto()
        return delegate.returningResponse(listOf(carDto)).getCars()
    }
}