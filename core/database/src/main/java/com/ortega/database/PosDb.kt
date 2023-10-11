package com.ortega.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ortega.database.dao.UserDao
import com.ortega.database.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class PosDb : RoomDatabase() {

    abstract fun userDao(): UserDao


}