package com.ortega.auth

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ortega.data.repository.UserRepositoryImpl
import com.ortega.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepositoryImpl: UserRepositoryImpl
) : ViewModel() {

    private var _userPassword by mutableStateOf("")

    private var _uiState = MutableStateFlow(AuthUiState())
    val uiState = _uiState.asStateFlow()

    fun userAuthentication(password: String) {
        _uiState.update { state -> state.copy(isLoading = true) }

        viewModelScope.launch {
            userRepositoryImpl.userAuthentication(password).collectLatest {
                _uiState.update { state -> state.copy(isLoading = false) }
            }
        }

    }

    fun insertUser(user: User) {
        _uiState.update { state -> state.copy(isLoading = true) }

        viewModelScope.launch {
            userRepositoryImpl.insertUser(user).collectLatest {
                _uiState.update { state -> state.copy(isLoading = false, success = user) }
            }
        }
    }

    fun alreadyAuthenticated(): String {

        viewModelScope.launch {
            userRepositoryImpl.getUserPassword().collectLatest {
                _userPassword = it
            }
        }

        return _userPassword
    }
}