package com.ortega.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.ortega.domain.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class UserPreferences(private val context: Context) {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("User")

        private val USERNAME_KEY = stringPreferencesKey("name")
        private val PASSWORD_KEY = stringPreferencesKey("password")

    }

    suspend fun saveUserInfo(user: User) {
        context.dataStore.edit {
            it[USERNAME_KEY] = user.username
            it[PASSWORD_KEY] = user.password
        }
    }

    suspend fun clearUserInfo() {
        context.dataStore.edit {
            it.clear()
        }
    }

    fun getUserPassword() =
        context.dataStore.data.map { it[PASSWORD_KEY] ?: "" }.flowOn(Dispatchers.IO)

}