package me.moallemi.carexplorer.data.entity

import me.moallemi.carexplorer.domain.model.Car

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