package com.ortega.design.common

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog
import com.ortega.design.theme.Padding

@Composable
fun DialogComponent(
    title: String,
    titleButton: String,
    setShowDialog: (Boolean) -> Unit,
    content: @Composable () -> Unit,
    onClick: () -> Unit
) {

    Dialog(
        onDismissRequest = { setShowDialog(false) },
    ) {
        Surface (
            color = MaterialTheme.colorScheme.background,
            shape = RoundedCornerShape(Padding)
        ) {
            LazyColumn (
            ) {
                item {
                    HeightSpacer(height = Padding)
                    HeaderTextComponent(text = title)
                    HeightSpacer(height = Padding)
                }

                item { content() }

                item {
                    HeightSpacer(height = Padding)
                    ButtonComponent(onClick = { onClick() }, text = titleButton)
                    HeightSpacer(height = Padding)
                }
            }
        }
    }
    
}