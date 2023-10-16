package com.ortega.domain.repository

import androidx.annotation.WorkerThread
import com.ortega.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun insertUser(user: User): Flow<User>

    fun userAuthentication(password: String): Flow<User?>

    fun getUserPassword(): Flow<String?>

    suspend fun clearUserInfo()

}