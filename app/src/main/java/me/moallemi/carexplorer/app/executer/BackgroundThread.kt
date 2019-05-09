package me.moallemi.carexplorer.app.executer

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import me.moallemi.carexplorer.domain.executor.PostExecutionThread

class BackgroundThread : PostExecutionThread {
    override val scheduler: Scheduler by lazy { Schedulers.io() }
}