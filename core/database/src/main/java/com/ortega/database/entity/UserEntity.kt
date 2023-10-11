package com.ortega.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "user")
data class UserEntity (
    @PrimaryKey val userId: UUID = UUID.randomUUID(),
    val username: String,
    val password: String
)