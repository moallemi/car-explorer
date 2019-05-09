package me.moallemi.carexplorer.data.repository

import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import me.moallemi.carexplorer.data.datasource.CarRemoteDataSource
import me.moallemi.carexplorer.data.entity.toCar
import org.junit.Before
import org.junit.Test
import java.io.IOException

class CarRepositoryImplTest {

    private val carRemoteDataSource: CarRemoteDataSource = mockk()
    private val carRepository = CarRepositoryImpl(carRemoteDataSource)

    @Before
    fun setUp() {
        clearAllMocks()
    }

    @Test
    fun `getCars when successful`() {
        val carEntity = CarFactory.createCarEntity()
        every { carRemoteDataSource.getCars() } returns Single.just(listOf(carEntity))

        carRepository.getCars()
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue(listOf(carEntity.toCar()))
    }

    @Test
    fun `getCars when fails`() {
        every { carRemoteDataSource.getCars() } returns Single.error(IOException())

        carRepository.getCars()
            .test()
            .assertNotComplete()
            .assertFailure(IOException::class.java)
    }
}