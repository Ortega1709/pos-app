package com.ortega.data.repository

import android.util.Log
import androidx.annotation.WorkerThread
import com.ortega.database.dao.UserDao
import com.ortega.database.entity.mapper.UserEntityMapper
import com.ortega.domain.model.User
import com.ortega.domain.repository.UserRepository
import com.ortega.preferences.UserPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val userPreferences: UserPreferences
) : UserRepository {

    override fun insertUser(user: User) = flow {

        userDao.insertUser(userEntity = UserEntityMapper.toEntity(user))
        emit(user)

    }.flowOn(Dispatchers.IO)

    override fun userAuthentication(password: String) = flow {

        val user = userDao.getUser(password = password)
        if (user != null) {
            emit(user)
            userPreferences.saveUserInfo(user)
        } else emit(null)

    }.flowOn(Dispatchers.IO)

    override fun getUserPassword() = userPreferences.getUserPassword()

    override suspend fun clearUserInfo() = userPreferences.clearUserInfo()

}