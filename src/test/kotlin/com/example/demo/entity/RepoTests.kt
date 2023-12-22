package com.example.demo.entity

import com.example.demo.repo.TestEntityRepository
import com.example.demo.test.FullAppContextTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


@FullAppContextTest
class RepoTests(
        val repository: TestEntityRepository
) {
    @Test
    fun selectExtended() {
        val extendEntities = repository.getExtendedEntities()
        assertEquals(1, extendEntities.size)
    }
}
