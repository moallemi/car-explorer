package me.moallemi.sixt.data.entity

import me.moallemi.sixt.domain.model.Car

fun CarEntity.toCar() = Car(
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