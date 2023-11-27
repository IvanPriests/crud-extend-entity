package com.example.demo

import com.github.f4b6a3.ulid.Ulid
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.PersistenceCreator
import org.springframework.data.relational.core.mapping.Embedded
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant
import java.util.UUID

@Table("entity_table")
data class Entity(
    @Embedded.Nullable
    val nestedEntity: NestedEntity,
    @Id
    val id: EntityId = EntityId.new(),
    val time: Instant,
) {
    @PersistenceCreator
    constructor(
        id: Ulid,
        time: Instant,
        nestedEntity: NestedEntity,
    ) : this(
        nestedEntity,
        EntityId(id),
        time
    )
}

data class NestedEntity(
    val nestedValue: String,
)

data class ExtendEntity(
    @Embedded.Nullable
    val entity: Entity,
    val extendValue: Int,
)

@JvmInline
value class EntityId(val raw: Ulid) {
    companion object {
        fun new(): EntityId = EntityId(Ulid.from(UUID.randomUUID()))
    }
}