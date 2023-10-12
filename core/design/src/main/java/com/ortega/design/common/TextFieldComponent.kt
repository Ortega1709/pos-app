package com.ortega.design.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.ortega.design.R
import com.ortega.design.theme.HeightTextField
import com.ortega.design.theme.Padding

@Composable
fun TextFieldComponent(
    imageVector: ImageVector,
    placeholder: String,
    textField: String,
    keyboardType: KeyboardType,
    onValueChange: (String) -> Unit
) {

    OutlinedTextField(
        modifier = Modifier
            .height(height = HeightTextField)
            .fillMaxWidth()
            .padding(horizontal = Padding),
        leadingIcon = {
            Icon(
                imageVector = imageVector,
                contentDescription = null
            )
        },
        shape = MaterialTheme.shapes.medium,
        colors = colorsTextFieldComponent(),
        placeholder = {
            TextComponent(
                text = placeholder,
                color = Color.Gray
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        value = textField,
        onValueChange = onValueChange
    )
}

@Composable
fun PasswordFieldComponent(
    imageVector: ImageVector,
    placeholder: String,
    textField: String,
    keyboardType: KeyboardType,
    onValueChange: (String) -> Unit
) {

    var visible by remember { mutableStateOf(false) }



    OutlinedTextField(
        modifier = Modifier
            .height(height = HeightTextField)
            .fillMaxWidth()
            .padding(horizontal = Padding),
        leadingIcon = {
            Icon(
                imageVector = imageVector,
                contentDescription = stringResource(R.string.leading_icons)
            )
        },
        shape = MaterialTheme.shapes.medium,
        colors = colorsTextFieldComponent(),
        placeholder = {
            TextComponent(
                text = placeholder,
                color = Color.Gray
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        value = textField,
        trailingIcon = {
            IconButton(onClick = { visible = !visible }) {
                Icon(
                    imageVector =
                    if (visible) Icons.Rounded.Visibility else Icons.Rounded.VisibilityOff,
                    contentDescription = stringResource(R.string.visibility)
                )
            }
        },
        visualTransformation = if (visible) VisualTransformation.None else PasswordVisualTransformation(),
        onValueChange = onValueChange
    )
}

@Composable
fun TextFieldComponent(
    placeholder: String,
    textField: String,
    keyboardType: KeyboardType,
    onValueChange: (String) -> Unit
) {

    OutlinedTextField(
        modifier = Modifier
            .height(height = HeightTextField)
            .fillMaxWidth()
            .padding(horizontal = Padding),
        shape = MaterialTheme.shapes.medium,
        colors = colorsTextFieldComponent(),
        placeholder = {
            TextComponent(
                text = placeholder,
                color = Color.Gray
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        value = textField,
        onValueChange = onValueChange
    )
}

@Composable
fun TextFieldComponent(
    imageVector: ImageVector,
    placeholder: String,
    textField: String,
    maxLines: Int,
    keyboardType: KeyboardType,
    onValueChange: (String) -> Unit
) {

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Padding),
        leadingIcon = {
            Icon(
                imageVector = imageVector,
                contentDescription = null
            )
        },
        shape = MaterialTheme.shapes.medium,
        colors = colorsTextFieldComponent(),
        maxLines = maxLines,
        placeholder = {
            TextComponent(
                text = placeholder,
                color = Color.Gray
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        value = textField,
        onValueChange = onValueChange
    )
}

