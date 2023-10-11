package com.ortega.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "lineItem")
data class LineItemEntity(
    @PrimaryKey val lineItemId: UUID = UUID.randomUUID(),
    val orderId: UUID,
    val item: String,
    val qte: Int,
    val price: Float,
    val unit: String,
    val itemId: UUID,
    val unitId: UUID
)
