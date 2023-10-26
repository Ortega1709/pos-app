package com.ortega.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ortega.database.entity.CategoryEntity
import java.util.UUID

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category")
    fun allCategoriesPaged(): PagingSource<Int, CategoryEntity>

    @Insert
    fun insertCategory(categoryEntity: CategoryEntity)

    @Query("SELECT COUNT(*) FROM category")
    fun countAllCategories(): Int

    @Query("DELETE FROM category WHERE categoryId = :categoryId")
    suspend fun deleteCategory(categoryId: UUID)

    @Query("UPDATE category SET name = :name WHERE categoryId = :categoryId")
    suspend fun updateCategory(name: String, categoryId: UUID)

}