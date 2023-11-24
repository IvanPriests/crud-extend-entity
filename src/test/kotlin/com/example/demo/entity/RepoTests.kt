package com.example.demo.entity

import com.example.demo.repo.EntityRepository
import com.example.demo.test.FullAppContextTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


@FullAppContextTest
class RepoTests(
        val repository: EntityRepository
) {
    @Test
    fun selectExtended() {
        val extendEntities = repository.getExtendedEntities()
        assertEquals(1, extendEntities.size)
    }
}
