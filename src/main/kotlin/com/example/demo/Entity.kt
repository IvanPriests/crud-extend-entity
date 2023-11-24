package com.example.demo

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Embedded
import org.springframework.data.relational.core.mapping.Table

@Table("entity_table")
data class Entity(
    @Embedded.Nullable
    val nestedEntity: NestedEntity,
    @Id
    val id: String,
)

data class NestedEntity (
    val nestedValue: String
)

data class ExtendEntity(
    @Embedded.Nullable
    val entity: Entity,
    val extendValue: Int
)
