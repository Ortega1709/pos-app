package com.ortega.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "category")
data class CategoryEntity (
    @PrimaryKey val categoryId: UUID = UUID.randomUUID(),
    val name: String
)