package com.ortega.data.module

import com.ortega.data.repository.UserRepositoryImpl
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

}