package com.ortega.domain

import java.util.UUID

data class Item(
    val itemId: UUID,
    val description: String,
    val price: Float,
    val qte: Int,
    val marque: String,
    val categoryId: UUID,
    val unitId: UUID
)

