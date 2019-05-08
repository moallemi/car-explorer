package me.moallemi.sixt.ui.browse.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.invoke
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import me.moallemi.sixt.domain.interactor.GetCarsUseCase
import me.moallemi.sixt.domain.model.Car
import me.moallemi.sixt.model.ResourceState
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.io.IOException

class BrowseViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val getCarsUseCase: GetCarsUseCase = mockk(relaxed = true)
    private val viewModel = BrowseViewModel(getCarsUseCase)

    @Before
    fun setUp() {
        clearAllMocks()
    }

    @Test
    fun `getCarsUseCase executes`() {
        viewModel.load()

        verify(exactly = 1) {
            getCarsUseCase.execute(any(), any(), any())
        }
    }

    @Test
    fun `getCarsUseCase success`() {
        val success = slot<(List<Car>) -> Unit>()

        every {
            getCarsUseCase.execute(any(), capture(success), any())
        } answers {
            success.invoke(listOf(CarFactory.createCar()))
        }

        viewModel.load()
        Assert.assertEquals(viewModel.cars.value?.resourceState, ResourceState.SUCCESS)
    }

    @Test
    fun `getCarsUseCase success and contains data`() {
        val success = slot<(List<Car>) -> Unit>()

        every {
            getCarsUseCase.execute(any(), capture(success), any())
        } answers {
            success.invoke(listOf(CarFactory.createCar()))
        }

        viewModel.load()
        Assert.assertEquals(viewModel.cars.value?.resourceState, ResourceState.SUCCESS)
        Assert.assertEquals(viewModel.cars.value?.data, listOf(CarFactory.createCar()))
    }

    @Test
    fun `getCarsUseCase fails`() {
        val failure = slot<(Throwable) -> Unit>()

        every {
            getCarsUseCase.execute(any(), any(), capture(failure))
        } answers {
            failure.invoke(IOException())
        }

        viewModel.load()
        Assert.assertEquals(viewModel.cars.value?.resourceState, ResourceState.ERROR)
    }

    @Test
    fun `getCarsUseCase fails and contains error data`() {
        val failure = slot<(Throwable) -> Unit>()

        every {
            getCarsUseCase.execute(any(), any(), capture(failure))
        } answers {
            failure.invoke(IOException())
        }

        viewModel.load()
        Assert.assertEquals(viewModel.cars.value?.resourceState, ResourceState.ERROR)
        assert(viewModel.cars.value?.failure is IOException)
    }

    @Test
    fun `getCarsUseCase returns loading`() {
        viewModel.load()
        assert(viewModel.cars.value?.resourceState == ResourceState.LOADING)
    }

    @Test
    fun `getCarsUseCase contains no data when loading`() {
        viewModel.load()

        assert(viewModel.cars.value?.resourceState == ResourceState.LOADING)
        assert(viewModel.cars.value?.data == null)
    }

    @Test
    fun `getCarsUseCase contains no error when loading`() {
        viewModel.load()

        assert(viewModel.cars.value?.resourceState == ResourceState.LOADING)
        assert(viewModel.cars.value?.failure == null)
    }
}