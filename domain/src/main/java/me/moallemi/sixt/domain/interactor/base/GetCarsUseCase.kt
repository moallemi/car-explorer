package me.moallemi.sixt.domain.interactor.base

import io.reactivex.Single
import me.moallemi.sixt.domain.executor.PostExecutionThread
import me.moallemi.sixt.domain.executor.UseCaseExecutorThread
import me.moallemi.sixt.domain.model.Car
import me.moallemi.sixt.domain.repository.CarRepository
import javax.inject.Inject

class GetCarsUseCase @Inject constructor(
    private val carRepository: CarRepository,
    useCaseExecutorThread: UseCaseExecutorThread,
    postExecutionThread: PostExecutionThread
) : SingleUseCase<List<Car>, GetCarsUseCase.None>(useCaseExecutorThread, postExecutionThread) {

    override fun buildSingle(params: None): Single<List<Car>> {
        return carRepository.getCars()
    }

    class None
}