package me.moallemi.sixt.app.executer

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import me.moallemi.sixt.domain.executor.PostExecutionThread

class BackgroundThread : PostExecutionThread {
    override val scheduler: Scheduler by lazy { Schedulers.io() }
}