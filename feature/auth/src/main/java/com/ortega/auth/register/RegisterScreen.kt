package com.ortega.auth.register

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Password
import androidx.compose.material.icons.rounded.Person2
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import com.ortega.auth.AuthViewModel
import com.ortega.auth.R
import com.ortega.design.auth.HeaderImageComponent
import com.ortega.design.auth.HeaderTextComponent
import com.ortega.design.common.ButtonComponent
import com.ortega.design.common.HeightSpacer
import com.ortega.design.common.PasswordFieldComponent
import com.ortega.design.common.TextFieldComponent
import com.ortega.design.common.ToastComponent
import com.ortega.design.theme.Padding
import com.ortega.domain.model.User
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(
    viewModel: AuthViewModel,
    goToLoginScreen: () -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    var nameField by remember { mutableStateOf("") }
    var passwordField by remember { mutableStateOf("") }

    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { paddingValues ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = paddingValues)
            ) {

                HeaderImageComponent()
                HeightSpacer(height = Padding)
                HeaderTextComponent(text = stringResource(R.string.header_text_register))

                HeightSpacer(height = Padding)

                TextFieldComponent(
                    imageVector = Icons.Rounded.Person2,
                    placeholder = stringResource(R.string.name),
                    textField = nameField,
                    keyboardType = KeyboardType.Text,
                    onValueChange = { nameField = it }
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
                        if (nameField != "" && passwordField != "") {
                            val user = User(null, username = nameField, password = passwordField)
                            viewModel.insertUser(user)

                            goToLoginScreen()
                        } else {
                            Toast.makeText(context, "All fields are required", Toast.LENGTH_SHORT)
                                .show()
                        }
                    },
                    text = stringResource(R.string.save)
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
}