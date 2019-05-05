package me.moallemi.sixt.domain.executor

import io.reactivex.Scheduler

interface UseCaseExecutorThread {

    val scheduler: Scheduler
}