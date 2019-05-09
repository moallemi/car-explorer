package me.moallemi.carexplorer.domain.interactor

import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import me.moallemi.carexplorer.domain.executor.PostExecutionThread
import me.moallemi.carexplorer.domain.executor.UseCaseExecutorThread
import me.moallemi.carexplorer.domain.repository.CarRepository
import org.junit.Before
import org.junit.Test
import java.io.IOException

class GetCarsUseCaseTest {

    private val carRepository: CarRepository = mockk()
    private val useCaseExecutorThread: UseCaseExecutorThread = mockk(relaxed = true)
    private val postExecutionThread: PostExecutionThread = mockk(relaxed = true)

    private val useCase = GetCarsUseCase(carRepository, useCaseExecutorThread, postExecutionThread)
    private val params = GetCarsUseCase.None()

    @Before
    fun setUp() {
        clearAllMocks()
    }

    @Test
    fun `getCars from repository was called`() {
        mockRepositoryGetCarsResponse()

        useCase.execute(params, {}, {})

        verify(exactly = 1) {
            carRepository.getCars()
        }
    }

    @Test
    fun `getCars when successful`() {
        mockRepositoryGetCarsResponse()

        useCase.buildSingle(params)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue(listOf(CarFactory.createCar()))
    }

    @Test
    fun `getCars when fails`() {
        every { carRepository.getCars() } returns Single.error(IOException())

        useCase.buildSingle(params)
            .test()
            .assertNotComplete()
            .assertFailure(IOException::class.java)
    }

    private fun mockRepositoryGetCarsResponse() {
        every { carRepository.getCars() } returns Single.just(listOf(CarFactory.createCar()))
    }
}