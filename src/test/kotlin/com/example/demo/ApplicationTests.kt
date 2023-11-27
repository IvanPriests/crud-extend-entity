package com.example.demo


import com.example.demo.test.FullAppContextTest
import com.github.f4b6a3.ulid.Ulid
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter
import org.springframework.data.convert.WritingConverter
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration

@FullAppContextTest
class ApplicationTests {

    @Test
    fun contextLoads() {
    }
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
