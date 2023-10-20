package com.ortega.database.module

import android.content.Context
import androidx.room.Room
import com.ortega.database.PosDb
import com.ortega.database.dao.UnitDao
import com.ortega.database.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun providePosDb(@ApplicationContext context: Context): PosDb {

        val db by lazy {
            Room.databaseBuilder(
                context = context,
                klass = PosDb::class.java,
                name = "pos.db"
            ).build()
        }

        return db
    }

    @Provides
    fun provideUserDao(posDb: PosDb): UserDao {
        return posDb.userDao()
    }

    @Provides
    fun provideUnitDao(posDb: PosDb): UnitDao {
        return posDb.unitDao()
    }

}