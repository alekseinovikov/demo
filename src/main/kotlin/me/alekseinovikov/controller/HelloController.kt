package me.alekseinovikov.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import kotlinx.coroutines.future.future
import me.alekseinovikov.service.HelloService
import java.util.concurrent.CompletableFuture


@Controller("/hello")
class HelloController(private val helloService: HelloService) : ControllerScope {

    @Get("/")
    @Produces(MediaType.TEXT_PLAIN)
    fun index(): CompletableFuture<String> = future {
        return@future helloService.hello()
    }

}