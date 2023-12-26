package com.example.demo

import com.github.f4b6a3.ulid.Ulid
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.beans
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter
import org.springframework.data.convert.WritingConverter
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories

@SpringBootApplication
@EnableJdbcRepositories
class Application

//object AppInitiolizer:ApplicationContextInitializer<GenericApplicationContext>{
////	override fun initialize(applicationContext: GenericApplicationContext) = beans {
////	}.initialize(applicationContext)
//}

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}

@Configuration
class JdbcConvertersRegistrarConfiguration : AbstractJdbcConfiguration() {
	override fun userConverters(): List<*> = listOf(
		UlidToString(),
		StringToUlid(),
	)
}

@ReadingConverter
class StringToUlid : Converter<String, Ulid> {
	override fun convert(source: String): Ulid = Ulid.from(source)
}

@WritingConverter
class UlidToString : Converter<Ulid, String> {
	override fun convert(source: Ulid): String = source.toString()
}
