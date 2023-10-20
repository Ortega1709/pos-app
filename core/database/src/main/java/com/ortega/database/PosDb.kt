package com.ortega.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ortega.database.dao.UnitDao
import com.ortega.database.dao.UserDao
import com.ortega.database.entity.UnitEntity
import com.ortega.database.entity.UserEntity

@Database(entities = [UserEntity::class, UnitEntity::class], version = 1)
abstract class PosDb : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun unitDao(): UnitDao


}