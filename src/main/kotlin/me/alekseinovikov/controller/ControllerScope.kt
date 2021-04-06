package me.alekseinovikov.controller

import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.rx2.SchedulerCoroutineDispatcher
import kotlin.coroutines.CoroutineContext

interface ControllerScope : CoroutineScope {
    // using RxJava scheduler for instrumentation
    override val coroutineContext: CoroutineContext
        get() = SchedulerCoroutineDispatcher(Schedulers.computation())
}