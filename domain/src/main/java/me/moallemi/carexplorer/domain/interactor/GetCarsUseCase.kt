package me.moallemi.carexplorer.domain.interactor

import io.reactivex.Single
import me.moallemi.carexplorer.domain.executor.PostExecutionThread
import me.moallemi.carexplorer.domain.executor.UseCaseExecutorThread
import me.moallemi.carexplorer.domain.interactor.base.SingleUseCase
import me.moallemi.carexplorer.domain.model.Car
import me.moallemi.carexplorer.domain.repository.CarRepository
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