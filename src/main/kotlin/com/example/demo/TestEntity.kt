package com.example.demo

import com.github.f4b6a3.ulid.Ulid
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.PersistenceCreator
import org.springframework.data.relational.core.mapping.Embedded
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant
import java.util.UUID

@Table(value ="entity_table")
class TestEntity(
    @Embedded.Nullable
    val nestedEntity: NestedEntity,
    val time: Instant,
    @Id
    val id: EntityId = EntityId.new(),
) {

    var statusTimestamp: Instant = Instant.EPOCH
        private set

    @PersistenceCreator
    constructor(
        id: Ulid,
        time: Instant,
        nestedEntity: NestedEntity,
    ) : this(
        nestedEntity,
        time,
        EntityId(id),
    )
}

data class NestedEntity(
    val nestedValue: String,
)

data class ExtendEntity(
    @Embedded.Nullable
    val entity: TestEntity,
    val extendValue: Int,
)

@JvmInline
value class EntityId(val raw: Ulid) {
    companion object {
        fun new(): EntityId = EntityId(Ulid.from(UUID.randomUUID()))
    }
}