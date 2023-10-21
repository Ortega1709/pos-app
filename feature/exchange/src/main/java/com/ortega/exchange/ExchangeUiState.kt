package com.ortega.exchange

import com.ortega.domain.model.Rate


data class ExchangeUiState(
    val rate: Rate = Rate(rateId = null, rate = 0)
)