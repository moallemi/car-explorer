package me.moallemi.carexplorer.app.executer

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import me.moallemi.carexplorer.domain.executor.UseCaseExecutorThread

class MainThread : UseCaseExecutorThread {
    override val scheduler: Scheduler by lazy { AndroidSchedulers.mainThread() }
}