package me.moallemi.carexplorer.remote.api

import io.reactivex.Single
import me.moallemi.carexplorer.remote.dto.CarDto
import retrofit2.http.GET

interface CarService {

    @GET("cars")
    fun getCars(): Single<List<CarDto>>

    companion object {
        const val BASE_URL = "https://cdn.sixt.io/codingtask/"
    }
}