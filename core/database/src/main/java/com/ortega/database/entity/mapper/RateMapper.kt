package com.ortega.database.entity.mapper

import com.ortega.database.entity.RateEntity
import com.ortega.domain.model.Rate

fun Rate.toEntity(): RateEntity {
    return RateEntity(
        rate = rate
    )
}

fun RateEntity.toDomain(): Rate {
    return Rate(
        rateId = rateId,
        rate = rate
    )
}