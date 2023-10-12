package com.ortega.auth.register

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Password
import androidx.compose.material.icons.rounded.Person2
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.ortega.auth.R
import com.ortega.design.auth.HeaderImageComponent
import com.ortega.design.auth.HeaderTextComponent
import com.ortega.design.common.ButtonComponent
import com.ortega.design.common.HeightSpacer
import com.ortega.design.common.PasswordFieldComponent
import com.ortega.design.common.TextFieldComponent
import com.ortega.design.theme.Padding

@Composable
fun RegisterScreen() {

    var nameField by remember { mutableStateOf("") }
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
                    onClick = {},
                    text = stringResource(R.string.save)
                )
            }

        }
    }

}