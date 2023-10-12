package com.ortega.design.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import com.ortega.design.theme.HeightTextField

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
            .fillMaxWidth(),
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
fun TextFieldComponent(
    placeholder: String,
    textField: String,
    keyboardType: KeyboardType,
    onValueChange: (String) -> Unit
) {

    OutlinedTextField(
        modifier = Modifier
            .height(height = HeightTextField)
            .fillMaxWidth(),
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
            .fillMaxWidth(),
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