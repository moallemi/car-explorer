package me.moallemi.carexplorer.app.executer

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import me.moallemi.carexplorer.domain.executor.UseCaseExecutorThread

class BackgroundThread : UseCaseExecutorThread {
    override val scheduler: Scheduler by lazy { Schedulers.io() }
}