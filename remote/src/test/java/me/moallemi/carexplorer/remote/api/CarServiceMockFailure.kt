package me.moallemi.carexplorer.remote.api

import io.reactivex.Single
import me.moallemi.carexplorer.remote.dto.CarDto
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.mock.BehaviorDelegate
import retrofit2.mock.Calls

class CarServiceMockFailure(private val delegate: BehaviorDelegate<CarService>) : CarService {

    override fun getCars(): Single<List<CarDto>> {
        val response = Response.error<List<CarDto>>(404, ResponseBody.create(MediaType.parse("application/json"), "{}"))
        return delegate.returning(Calls.response(response)).getCars()
    }
}