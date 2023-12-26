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
