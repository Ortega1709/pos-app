package com.ortega.domain.repository

import androidx.paging.PagingData
import com.ortega.domain.model.Unit
import kotlinx.coroutines.flow.Flow

interface UnitRepository {

    fun insertUnit(unit: Unit): Flow<Unit>

    fun allUnitsPaged(): Flow<PagingData<Unit>>

    fun countAllUnits(): Flow<Int>

    fun deleteUnit(unit: Unit): Flow<Unit>

    fun updateUnit(unit: Unit): Flow<Unit>

}