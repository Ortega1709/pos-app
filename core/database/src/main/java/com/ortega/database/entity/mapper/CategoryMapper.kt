package com.ortega.database.entity.mapper

import com.ortega.database.entity.CategoryEntity
import com.ortega.domain.model.Category

fun Category.toEntity(): CategoryEntity {
    return CategoryEntity(name = name)
}

fun CategoryEntity.toDomain(): Category {
    return Category(categoryId = categoryId, name = name)
}