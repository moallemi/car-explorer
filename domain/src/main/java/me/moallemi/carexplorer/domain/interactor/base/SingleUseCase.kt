package me.moallemi.carexplorer.domain.interactor.base

import io.reactivex.Single
import me.moallemi.carexplorer.domain.executor.PostExecutionThread
import me.moallemi.carexplorer.domain.executor.UseCaseExecutorThread
import me.moallemi.carexplorer.domain.observer.SingleObserver

abstract class SingleUseCase<Result, in Params>(
    private val useCaseExecutorThread: UseCaseExecutorThread,
    private val postExecutionThread: PostExecutionThread
) : UseCase() {

    abstract fun buildSingle(params: Params): Single<Result>

    fun execute(
        params: Params,
        success: (Result) -> Unit,
        failure: (Throwable) -> Unit
    ) {
        buildSingle(params)
            .observeOn(useCaseExecutorThread.scheduler)
            .subscribeOn(postExecutionThread.scheduler)
            .subscribeWith(SingleObserver(success, failure))
            .also { observer ->
                addDisposable(observer)
            }
    }
}