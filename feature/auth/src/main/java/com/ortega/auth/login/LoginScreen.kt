package com.ortega.auth.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Password
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ortega.auth.AuthViewModel
import com.ortega.auth.R
import com.ortega.design.auth.HeaderImageComponent
import com.ortega.design.common.ButtonComponent
import com.ortega.design.common.HeaderTextComponent
import com.ortega.design.common.HeightSpacer
import com.ortega.design.common.PasswordFieldComponent
import com.ortega.design.theme.Padding
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    viewModel: AuthViewModel,
    goToHomeScreen: () -> Unit
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    var passwordField by remember { mutableStateOf("") }
    val snackBarHostState = remember { SnackbarHostState() }

    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
            modifier = Modifier.fillMaxSize()
        ) { paddingValues ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = paddingValues)
                    .verticalScroll(rememberScrollState())
            ) {
                HeaderImageComponent()
                HeightSpacer(height = Padding)
                HeaderTextComponent(
                    text = stringResource(R.string.enter_password_for_show_home)
                )

                HeightSpacer(height = Padding)

                PasswordFieldComponent(
                    imageVector = Icons.Rounded.Password,
                    placeholder = stringResource(R.string.password),
                    textField = passwordField,
                    keyboardType = KeyboardType.Password,
                    onValueChange = { passwordField = it }
                )

                HeightSpacer(height = Padding)

                ButtonComponent(
                    isLoading = uiState.isLoading,
                    enable = !uiState.isLoading,
                    onClick = {
                        viewModel.userAuthentication(passwordField)
                    },
                    text = stringResource(R.string.connection)
                )
            }
        }
    }

    if (uiState.error != null) {
        SideEffect {
            coroutineScope.launch {
                snackBarHostState.showSnackbar(
                    message = uiState.error!!,
                    duration = SnackbarDuration.Short
                )
            }
        }
    }

    if (uiState.success != null) {
        goToHomeScreen()
    }
}

