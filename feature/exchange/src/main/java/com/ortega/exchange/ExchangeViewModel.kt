package com.ortega.exchange

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ortega.data.repository.RateRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExchangeViewModel @Inject constructor(
    private val rateRepositoryImpl: RateRepositoryImpl
) : ViewModel() {

    private val _state = MutableStateFlow(ExchangeUiState())
    val state = _state.asStateFlow()

    init {
        getRate()
    }

    fun getRate() {
        viewModelScope.launch {
            rateRepositoryImpl.getRate().collect { rate ->
               rate?.let {
                   _state.emit(ExchangeUiState(rate = it))
               }
            }
        }
    }
}