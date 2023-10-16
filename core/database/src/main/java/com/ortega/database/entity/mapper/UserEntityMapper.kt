package com.ortega.database.entity.mapper

import com.ortega.database.entity.UserEntity
import com.ortega.domain.model.User

object UserEntityMapper : EntityMapper<User, UserEntity> {
    override fun toEntity(domain: User): UserEntity {
        return UserEntity(username = domain.username, password = domain.password)
    }

    override fun toDomain(entity: UserEntity): User {
        return User(userId = entity.userId, username = entity.username, password = entity.password)
    }

}