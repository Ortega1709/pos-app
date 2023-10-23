package com.ortega.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ortega.database.entity.RateEntity
import com.ortega.domain.model.Rate

@Dao
interface RateDao {

    @Query("SELECT * FROM rate")
    suspend fun getRate(): Rate?

    @Insert
    suspend fun insertRate(rateEntity: RateEntity)

    @Query("DELETE FROM rate")
    suspend fun deleteAllRates()


}