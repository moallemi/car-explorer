package me.moallemi.sixt.remote.dto

import me.moallemi.sixt.data.entity.CarEntity

fun CarDto.toCarEntity() = CarEntity(
    carImageUrl = carImageUrl,
    color = color,
    fuelLevel = fuelLevel,
    fuelType = fuelType,
    group = group,
    id = id,
    innerCleanliness = innerCleanliness,
    latitude = latitude,
    licensePlate = licensePlate,
    longitude = longitude,
    make = make,
    modelIdentifier = modelIdentifier,
    modelName = modelName,
    name = name,
    series = series,
    transmission = transmission
)