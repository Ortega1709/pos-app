package com.ortega.unity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.ortega.data.repository.UnitRepositoryImpl
import com.ortega.domain.model.Unit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UnitViewModel @Inject constructor(
    private val unitRepositoryImpl: UnitRepositoryImpl
) : ViewModel() {

    val unitsPaged = unitRepositoryImpl.allUnitsPaged().cachedIn(viewModelScope)

    fun insertUnit(unit: Unit) {
        viewModelScope.launch {
            unitRepositoryImpl.insertUnit(unit).collect {}
        }
    }

    fun updateUnit(unit: Unit) {
        viewModelScope.launch {
            unitRepositoryImpl.updateUnit(unit).collect {}
        }
    }

    fun deleteUnit(unit: Unit) {
        viewModelScope.launch {
            unitRepositoryImpl.deleteUnit(unit).collect {}
        }
    }


}