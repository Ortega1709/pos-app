package com.ortega.data.repository

import com.ortega.database.dao.RateDao
import com.ortega.database.entity.mapper.toEntity
import com.ortega.domain.model.Rate
import com.ortega.domain.repository.RateRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RateRepositoryImpl @Inject constructor(
    private val rateDao: RateDao
): RateRepository {
    override fun getRate() = flow {
        emit(rateDao.getRate())
    }.flowOn(Dispatchers.IO)

    override fun updateRate(rate: Rate) = flow {
        rateDao.updateRate(rate.toEntity())
        emit(rate)
    }.flowOn(Dispatchers.IO)
}