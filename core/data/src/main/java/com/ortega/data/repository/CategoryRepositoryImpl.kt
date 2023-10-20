package com.ortega.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.ortega.database.dao.CategoryDao
import com.ortega.database.entity.CategoryEntity
import com.ortega.database.entity.mapper.toDomain
import com.ortega.database.entity.mapper.toEntity
import com.ortega.domain.model.Category
import com.ortega.domain.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryDao: CategoryDao
) : CategoryRepository {
    override fun insertCategory(category: Category) = flow {
        categoryDao.insertCategory(category.toEntity())
        emit(category)
    }.flowOn(Dispatchers.IO)

    override fun allCategoriesPaged() = Pager(
        PagingConfig(
            pageSize = PAGE_SIZE,
            prefetchDistance = PREFETCH_DISTANCE
        )
    ) {
        categoryDao.allCategoriesPaged()
    }
        .flow
        .map { value: PagingData<CategoryEntity> ->
            value.map { unitEntity ->
                unitEntity.toDomain()
            }
        }.flowOn(Dispatchers.IO)

    override fun countAllCategories() = flow {
        val categories = categoryDao.countAllCategories()
        emit(categories)
    }.flowOn(Dispatchers.IO)

    override fun deleteCategory(category: Category) = flow {
        categoryDao.deleteCategory(category.toEntity())
        emit(category)
    }.flowOn(Dispatchers.IO)

    companion object {
        private const val PAGE_SIZE = 10
        private const val PREFETCH_DISTANCE = 20
    }
}