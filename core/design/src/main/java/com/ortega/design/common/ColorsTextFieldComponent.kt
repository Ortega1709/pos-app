package com.ortega.design.common

import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.ortega.design.theme.DarkGray
import com.ortega.design.theme.White

@Composable
fun colorsTextFieldComponent(): TextFieldColors {
    return TextFieldDefaults.colors(
        focusedLeadingIconColor = White,
        unfocusedLeadingIconColor = Color.Gray,
        unfocusedTextColor = White,
        focusedTextColor = White,
        cursorColor = White,
        selectionColors = TextSelectionColors(
            handleColor = White,
            backgroundColor = White
        ),
        unfocusedContainerColor = DarkGray,
        focusedContainerColor = DarkGray,
        focusedIndicatorColor = DarkGray,
        unfocusedIndicatorColor = DarkGray,
    )
}