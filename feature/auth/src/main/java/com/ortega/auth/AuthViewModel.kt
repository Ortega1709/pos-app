package com.ortega.auth

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
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepositoryImpl: UserRepositoryImpl
) : ViewModel() {

    private var _userPassword by mutableStateOf(false)

    private var _uiState = MutableStateFlow(AuthUiState())
    val uiState = _uiState.asStateFlow()

    fun userAuthentication(password: String) {

        viewModelScope.launch {
            _uiState.emit(AuthUiState(isLoading = true))

            userRepositoryImpl.userAuthentication(password).collect {
                _uiState.emit(AuthUiState(isLoading = true))
            }
        }

    }

    fun insertUser(user: User) {

        viewModelScope.launch {
            _uiState.emit(AuthUiState(isLoading = true))

            userRepositoryImpl.insertUser(user).collect {
                _uiState.emit(AuthUiState(isLoading = true, success = user))
            }
        }
    }

    fun alreadyAuthenticated(): Boolean {

        viewModelScope.launch {
            userRepositoryImpl.getUserPassword().collect {
                _userPassword = it != ""
            }
        }

        return _userPassword
    }
}