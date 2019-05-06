package me.moallemi.sixt.remote.datasource

import me.moallemi.sixt.remote.dto.CarDto

object CarFactory {

    fun createCarDto() = CarDto(
        id = "WMWSW31030T222518",
        modelIdentifier = "mini",
        modelName = "MINI",
        name = "Vanessa",
        make = "BMW",
        group = "MINI",
        color = "midnight_black",
        series = "MINI",
        fuelType = "D",
        fuelLevel = 0.7,
        transmission = "M",
        licensePlate = "M-VO0259",
        latitude = 48.134557,
        longitude = 11.576921,
        innerCleanliness = "REGULAR",
        carImageUrl = "https://cdn.sixt.io/codingtask/images/mini.png"
    )
}