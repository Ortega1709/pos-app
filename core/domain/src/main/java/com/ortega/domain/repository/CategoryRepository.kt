package com.ortega.domain.repository

import androidx.paging.PagingData
import com.ortega.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    fun insertCategory(category: Category): Flow<Category>

    fun allCategoriesPaged(): Flow<PagingData<Category>>

    fun countAllCategories(): Flow<Int>

    fun deleteCategory(category: Category): Flow<Category>

}