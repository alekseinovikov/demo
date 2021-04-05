package me.alekseinovikov

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("me.alekseinovikov")
		.start()
}

