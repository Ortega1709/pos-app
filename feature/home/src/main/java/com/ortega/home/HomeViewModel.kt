package com.ortega.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ortega.data.repository.UnitRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val unitRepositoryImpl: UnitRepositoryImpl
) : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state = combine(
        unitRepositoryImpl.countAllUnits(),
        _state
    ) { units, state ->
        state.copy(units = units)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), _state.value)

}