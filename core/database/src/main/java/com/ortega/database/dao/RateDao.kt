package com.ortega.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ortega.database.entity.RateEntity
import com.ortega.domain.model.Rate

@Dao
interface RateDao {

    @Query("SELECT * FROM rate")
    suspend fun getRate(): Rate?

    @Upsert
    suspend fun updateRate(rateEntity: RateEntity)


}