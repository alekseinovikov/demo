package me.alekseinovikov.service

import kotlinx.coroutines.delay
import javax.inject.Singleton

@Singleton
class HelloServiceImpl : HelloService {
    override suspend fun hello(): String {
        delay(100)
        return "Hello!"
    }
}