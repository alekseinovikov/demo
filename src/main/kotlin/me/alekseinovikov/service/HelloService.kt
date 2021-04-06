package me.alekseinovikov.service

interface HelloService {
    suspend fun hello(): String
}