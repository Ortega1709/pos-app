package com.ortega.data.module

import com.ortega.data.repository.CategoryRepositoryImpl
import com.ortega.data.repository.UnitRepositoryImpl
import com.ortega.data.repository.UserRepositoryImpl
import com.ortega.database.dao.CategoryDao
import com.ortega.database.dao.UnitDao
import com.ortega.database.dao.UserDao
import com.ortega.preferences.UserPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideUserRepositoryImpl(
        userDao: UserDao,
        userPreferences: UserPreferences
    ): UserRepositoryImpl {

        return UserRepositoryImpl(userDao = userDao, userPreferences = userPreferences)

    }

    @Provides
    fun provideUnitRepositoryImpl(
        unitDao: UnitDao,
    ): UnitRepositoryImpl {

        return UnitRepositoryImpl(unitDao = unitDao)

    }

    @Provides
    fun provideCategoryRepositoryImpl(
        categoryDao: CategoryDao
    ): CategoryRepositoryImpl {

        return CategoryRepositoryImpl(categoryDao = categoryDao)

    }

}