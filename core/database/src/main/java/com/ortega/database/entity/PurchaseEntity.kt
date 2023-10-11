package com.ortega.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity(tableName = "purchase")
data class PurchaseEntity(
    @PrimaryKey val purchaseId: UUID = UUID.randomUUID(),
    val item: String,
    val qte: Int,
    val purchasePrice: Float,
    val total: Float,
    val completed: Boolean,
    val itemId: UUID,
    val unitId: UUID,
    val date: Date
)
