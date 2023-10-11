package com.ortega.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "item")
data class ItemEntity(
    @PrimaryKey val itemId: UUID = UUID.randomUUID(),
    val description: String,
    val price: Float,
    val qte: Int,
    val marque: String,
    val categoryId: UUID,
    val unitId: UUID
)
