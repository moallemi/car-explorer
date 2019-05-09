package me.moallemi.carexplorer.data.entity

import me.moallemi.carexplorer.data.repository.CarFactory
import org.junit.Assert
import org.junit.Test

class MappersTest {

    @Test
    fun `carDto to carEntity is successful`() {
        val carEntity = CarFactory.createCarEntity()
        val car = carEntity.toCar()

        Assert.assertEquals(carEntity.carImageUrl, car.carImageUrl)
        Assert.assertEquals(carEntity.color, car.color)
        Assert.assertEquals(carEntity.fuelLevel, car.fuelLevel)
        Assert.assertEquals(carEntity.fuelType, car.fuelType)
        Assert.assertEquals(carEntity.group, car.group)
        Assert.assertEquals(carEntity.id, car.id)
        Assert.assertEquals(carEntity.innerCleanliness, car.innerCleanliness)
        Assert.assertEquals(carEntity.latitude, car.latitude)
        Assert.assertEquals(carEntity.licensePlate, car.licensePlate)
        Assert.assertEquals(carEntity.longitude, car.longitude)
        Assert.assertEquals(carEntity.make, car.make)
        Assert.assertEquals(carEntity.modelIdentifier, car.modelIdentifier)
        Assert.assertEquals(carEntity.modelName, car.modelName)
        Assert.assertEquals(carEntity.name, car.name)
        Assert.assertEquals(carEntity.series, car.series)
        Assert.assertEquals(carEntity.transmission, car.transmission)
    }
}