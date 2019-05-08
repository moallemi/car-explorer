package me.moallemi.sixt.app.executer

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import me.moallemi.sixt.domain.executor.UseCaseExecutorThread

class MainThread : UseCaseExecutorThread {
    override val scheduler: Scheduler by lazy { AndroidSchedulers.mainThread() }
}