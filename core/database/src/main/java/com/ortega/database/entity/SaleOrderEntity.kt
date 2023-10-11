package com.ortega.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity(tableName = "saleOrder")
data class SaleOrderEntity(
    @PrimaryKey val saleOrderId: UUID = UUID.randomUUID(),
    val date: Date,
    val total: Float,
    val tax: Float,
    val subTotal: Float,
    val completed: Boolean
)
