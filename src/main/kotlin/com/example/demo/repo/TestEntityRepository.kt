package com.example.demo.repo

import com.example.demo.TestEntity
import com.example.demo.ExtendEntity
import com.github.f4b6a3.ulid.Ulid
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.core.EntityInformation
import org.springframework.stereotype.Repository

@Repository
interface TestEntityRepository : CrudRepository<TestEntity, Ulid>, EntityInformation<TestEntity, Ulid> {
    @Query("""
        SELECT *, 5 as extend_value FROM entity_table
        """)
    fun getExtendedEntities(): List<ExtendEntity>
}
