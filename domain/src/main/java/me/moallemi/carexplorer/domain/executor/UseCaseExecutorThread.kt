package me.moallemi.carexplorer.domain.executor

import io.reactivex.Scheduler

interface UseCaseExecutorThread {

    val scheduler: Scheduler
}