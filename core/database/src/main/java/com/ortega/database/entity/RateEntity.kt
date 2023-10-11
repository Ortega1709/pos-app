package com.ortega.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "rate")
data class RateEntity (
    @PrimaryKey val rateId: UUID = UUID.randomUUID(),
    val rate: Int
)