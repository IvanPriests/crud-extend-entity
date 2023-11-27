package com.example.demo.repo

import com.example.demo.Entity
import com.example.demo.ExtendEntity
import com.github.f4b6a3.ulid.Ulid
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface EntityRepository : CrudRepository<Entity, Ulid> {
    @Query("""
           SELECT *, 5 as extend_value FROM entity_table
        """)
    fun getExtendedEntities(): List<ExtendEntity>
}
