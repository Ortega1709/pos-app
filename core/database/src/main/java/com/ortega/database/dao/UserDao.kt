package com.ortega.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ortega.database.entity.UserEntity

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(userEntity: UserEntity)

    @Query("SELECT * FROM user WHERE password = :password")
    suspend fun getUser(password: String)

}