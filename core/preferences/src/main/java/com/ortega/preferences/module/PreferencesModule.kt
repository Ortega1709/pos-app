package com.ortega.preferences.module

import android.content.Context
import com.ortega.preferences.UserPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {

     @Provides
     fun provideUserPreferences(@ApplicationContext context: Context): UserPreferences {
         return UserPreferences(context)
     }

}