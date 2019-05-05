package me.moallemi.sixt.domain.executor

import io.reactivex.Scheduler

interface PostExecutionThread {

    val scheduler: Scheduler
}