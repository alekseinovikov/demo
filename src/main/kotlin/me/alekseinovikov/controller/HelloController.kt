package me.alekseinovikov.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.future.future
import kotlinx.coroutines.rx2.SchedulerCoroutineDispatcher
import java.util.concurrent.CompletableFuture
import kotlin.coroutines.CoroutineContext

interface ControllerScope : CoroutineScope {
    // using RxJava scheduler for instrumentation
    override val coroutineContext: CoroutineContext
        get() = SchedulerCoroutineDispatcher(Schedulers.computation())
}

@Controller("/hello")
class HelloController: ControllerScope {

    @Get("/")
    @Produces(MediaType.TEXT_PLAIN)
    fun index(): CompletableFuture<String> = future {
        return@future "Hello!"
    }

}