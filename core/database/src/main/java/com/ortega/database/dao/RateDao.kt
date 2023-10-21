package com.ortega.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.ortega.database.entity.RateEntity
import com.ortega.domain.model.Rate

@Dao
interface RateDao {

    @Query("SELECT * FROM rate")
    suspend fun getRate(): Rate

    @Update
    suspend fun updateRate(rateEntity: RateEntity)


}