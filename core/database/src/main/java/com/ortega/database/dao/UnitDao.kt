package com.ortega.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ortega.database.entity.UnitEntity
import java.util.UUID

@Dao
interface UnitDao {

    @Query("SELECT * FROM unit")
    fun allUnitsPaged(): PagingSource<Int, UnitEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUnit(unitEntity: UnitEntity)

    @Query("SELECT COUNT(*) FROM unit")
    suspend fun countAllUnits(): Int

    @Query("DELETE FROM unit WHERE unitId = :id")
    suspend fun deleteUnit(id: UUID)

    @Update
    suspend fun updateUnit(unitEntity: UnitEntity)


}