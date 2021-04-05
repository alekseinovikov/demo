package me.alekseinovikov

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.kotest.annotation.MicronautTest

@MicronautTest
class DemoTest(
    private val application: EmbeddedApplication<*>,
    @Client("/") private val client: RxHttpClient
) : StringSpec({

    "test the server is running" {
        application.isRunning.shouldBeTrue()
    }

    "hello endpoint must return hello" {
        val request: HttpRequest<Any> = HttpRequest.GET("/hello")
        val body = client.toBlocking().retrieve(request)

        body shouldBe "Hello!"
    }
})
