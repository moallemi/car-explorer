package me.moallemi.carexplorer.remote.datasource

import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import me.moallemi.carexplorer.remote.api.CarService
import me.moallemi.carexplorer.remote.dto.toCarEntity
import org.junit.Test
import java.io.IOException

class CarRemoteDataSourceImplTest {

    private val service: CarService = mockk()
    private val dataSource = CarRemoteDataSourceImpl(service)

    @Test
    fun `getCars when successful`() {
        every { service.getCars() } returns Single.just(listOf(CarFactory.createCarDto()))

        dataSource.getCars()
            .test()
            .assertSubscribed()
            .assertComplete()
            .assertNoErrors()
            .assertValue(listOf(CarFactory.createCarDto().toCarEntity()))
    }

    @Test
    fun `getCars when fails`() {
        every { service.getCars() } returns Single.error(IOException())

        dataSource.getCars()
            .test()
            .assertNotComplete()
            .assertError(IOException::class.java)
    }
}