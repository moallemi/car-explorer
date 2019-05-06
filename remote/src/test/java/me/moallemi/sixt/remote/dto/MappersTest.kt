package me.moallemi.sixt.remote.dto

import junit.framework.Assert.assertEquals
import me.moallemi.sixt.remote.datasource.CarFactory
import org.junit.Test

class MappersTest {

    @Test
    fun `carDto to carEntity is successful`() {
        val carDto = CarFactory.createCarDto()
        val carEntity = carDto.toCarEntity()

        assertEquals(carDto.carImageUrl, carEntity.carImageUrl)
        assertEquals(carDto.color, carEntity.color)
        assertEquals(carDto.fuelLevel, carEntity.fuelLevel)
        assertEquals(carDto.fuelType, carEntity.fuelType)
        assertEquals(carDto.group, carEntity.group)
        assertEquals(carDto.id, carEntity.id)
        assertEquals(carDto.innerCleanliness, carEntity.innerCleanliness)
        assertEquals(carDto.latitude, carEntity.latitude)
        assertEquals(carDto.licensePlate, carEntity.licensePlate)
        assertEquals(carDto.longitude, carEntity.longitude)
        assertEquals(carDto.make, carEntity.make)
        assertEquals(carDto.modelIdentifier, carEntity.modelIdentifier)
        assertEquals(carDto.modelName, carEntity.modelName)
        assertEquals(carDto.name, carEntity.name)
        assertEquals(carDto.series, carEntity.series)
        assertEquals(carDto.transmission, carEntity.transmission)
    }
}