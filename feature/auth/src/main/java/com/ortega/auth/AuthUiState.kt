package com.ortega.auth

import com.ortega.domain.model.User

data class AuthUiState (
    val isLoading: Boolean = false,
    val success: User? = null,
    val error: String? = null
)