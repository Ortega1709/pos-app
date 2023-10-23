package com.ortega.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "rate")
data class RateEntity (
    @PrimaryKey val rateId: UUID = UUID.fromString(RATE_ID),
    val rate: Int
) {

    companion object {
        const val RATE_ID = "b8e16acd-c43c-413c-9935-ea08967943b8"
    }

}