package com.ortega.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.ortega.data.repository.CategoryRepositoryImpl
import com.ortega.domain.model.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val categoryRepositoryImpl: CategoryRepositoryImpl
): ViewModel() {

    val categoriesPaged = categoryRepositoryImpl.allCategoriesPaged().cachedIn(viewModelScope)

    fun insertCategory(category: Category) {
        viewModelScope.launch {
            categoryRepositoryImpl.insertCategory(category).collect {  }
        }
    }

    fun updateCategory(category: Category) {
        viewModelScope.launch {
            categoryRepositoryImpl.updateCategory(category).collect {  }
        }
    }

    fun deleteCategory(category: Category) {
        viewModelScope.launch {
            categoryRepositoryImpl.deleteCategory(category).collect {  }
        }
    }

}