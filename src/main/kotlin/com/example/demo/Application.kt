package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.beans
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories

@SpringBootApplication
class Application

//object AppInitiolizer:ApplicationContextInitializer<GenericApplicationContext>{
////	override fun initialize(applicationContext: GenericApplicationContext) = beans {
////	}.initialize(applicationContext)
//}

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
