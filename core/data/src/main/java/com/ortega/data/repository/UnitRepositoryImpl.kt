package com.ortega.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.ortega.database.dao.UnitDao
import com.ortega.database.entity.UnitEntity
import com.ortega.database.entity.mapper.toDomain
import com.ortega.database.entity.mapper.toEntity
import com.ortega.domain.model.Unit
import com.ortega.domain.repository.UnitRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UnitRepositoryImpl @Inject constructor(
    private val unitDao: UnitDao
) : UnitRepository {
    override fun insertUnit(unit: Unit) = flow {

        unitDao.insertUnit(unitEntity = unit.toEntity())
        emit(unit)

    }.flowOn(Dispatchers.IO)

    override fun allUnitsPaged() = Pager(
        PagingConfig(
            pageSize = PAGE_SIZE,
            prefetchDistance = PREFETCH_DISTANCE
        )
    ) {
        unitDao.allUnitsPaged()
    }
        .flow
        .map { value: PagingData<UnitEntity> ->
            value.map { unitEntity ->
                unitEntity.toDomain()
            }
        }.flowOn(Dispatchers.IO)

    override fun countAllUnits() = flow {
        val units = unitDao.countAllUnits()
        emit(units)
    }.flowOn(Dispatchers.IO)

    override fun deleteUnit(unit: Unit) = flow {
        unitDao.deleteUnit(unit.toEntity())
        emit(unit)
    }.flowOn(Dispatchers.IO)

    companion object {
        private const val PAGE_SIZE = 10
        private const val PREFETCH_DISTANCE = 20
    }

}