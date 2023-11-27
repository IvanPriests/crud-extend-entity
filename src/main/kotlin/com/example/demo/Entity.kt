package com.example.demo

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.PersistenceCreator
import org.springframework.data.relational.core.mapping.Embedded
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant

@Table("entity_table")
data class Entity(
        @Embedded.Nullable
        val nestedEntity: NestedEntity,
        @Id
        val id: EntityId,
        val time: Instant,
) {
    @PersistenceCreator
    constructor(
            id: String,
            nestedEntity: NestedEntity,
            time: Instant,
    ) : this(
            nestedEntity,
            EntityId(id),
            time)
}

data class NestedEntity(
        val nestedValue: String
)

data class ExtendEntity(
        @Embedded.Nullable
        val entity: Entity,
        val extendValue: Int
)

@JvmInline
value class EntityId(val raw: String)