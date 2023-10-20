package com.ortega.database.entity.mapper

import com.ortega.database.entity.UnitEntity
import com.ortega.domain.model.Unit

fun Unit.toEntity(): UnitEntity {
    return UnitEntity(name = name)
}

fun UnitEntity.toDomain(): Unit {
    return Unit(unitId = unitId, name = name)
}