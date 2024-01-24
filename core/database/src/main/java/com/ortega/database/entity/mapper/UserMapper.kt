package com.ortega.database.entity.mapper

import com.ortega.database.entity.UserEntity
import com.ortega.domain.model.User

fun User.toEntity(): UserEntity {
    return UserEntity(password = password)
}

fun UserEntity.toDomain(): User {
    return User(userId = userId, password = password)
}