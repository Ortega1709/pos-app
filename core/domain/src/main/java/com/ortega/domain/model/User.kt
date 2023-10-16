package com.ortega.domain.model

import java.util.UUID

data class User(
    val userId: UUID?,
    val username: String,
    val password: String
)
