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
    @Id
    val id: TestEntityId = TestEntityId.new(),
    val time: Instant,
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
        TestEntityId(id),
        time,
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
value class TestEntityId(val raw: Ulid) {
    fun encodeAsString(): String = raw.toString()
    companion object {
        fun new(): TestEntityId = TestEntityId(Ulid.from(UUID.randomUUID()))

        fun decode(str: String): TestEntityId = TestEntityId(Ulid.from(str))
    }
}