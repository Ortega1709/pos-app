package com.ortega.database.entity.mapper

interface EntityMapper<D, E> {

    fun toEntity(domain: D): E
    fun toDomain(entity: E): D

}