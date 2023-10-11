package com.ortega.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID


@Entity(tableName = "unit")
data class UnitEntity(
    @PrimaryKey val unitId: UUID = UUID.randomUUID(),
    val name: String
)