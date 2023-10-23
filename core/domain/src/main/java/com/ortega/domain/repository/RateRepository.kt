package com.ortega.domain.repository

import com.ortega.domain.model.Rate
import kotlinx.coroutines.flow.Flow

interface RateRepository {

    fun getRate(): Flow<Rate?>

    fun insertRate(rate: Rate): Flow<Rate>

}