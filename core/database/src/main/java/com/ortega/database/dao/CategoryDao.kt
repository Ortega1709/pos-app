package com.ortega.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ortega.database.entity.CategoryEntity

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category")
    fun allCategoriesPaged(): PagingSource<Int, CategoryEntity>

    @Insert
    fun insertCategory(categoryEntity: CategoryEntity)

    @Query("SELECT COUNT(*) FROM category")
    fun countAllCategories(): Int

    @Delete
    fun deleteCategory(categoryEntity: CategoryEntity)

}