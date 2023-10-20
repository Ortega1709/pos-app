package com.ortega.database.entity.mapper

import com.ortega.database.entity.UserEntity
import com.ortega.domain.model.User

fun User.toEntity(): UserEntity {
    return UserEntity(username = username, password = password)
}

fun UserEntity.toDomain(): User {
    return User(userId = userId, username = username, password = password)
}