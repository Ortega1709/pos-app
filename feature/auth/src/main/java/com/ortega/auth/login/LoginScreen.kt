package com.ortega.auth.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Password
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.ortega.auth.R
import com.ortega.design.auth.HeaderImageComponent
import com.ortega.design.auth.HeaderTextComponent
import com.ortega.design.common.ButtonComponent
import com.ortega.design.common.HeightSpacer
import com.ortega.design.common.PasswordFieldComponent
import com.ortega.design.common.TextFieldComponent
import com.ortega.design.theme.Padding
import com.ortega.design.theme.PosAppTheme

@Composable
fun LoginScreen() {

    var passwordField by remember { mutableStateOf("") }

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
                    onClick = {},
                    text = stringResource(R.string.connection)
                )
            }
        }
    }
}

