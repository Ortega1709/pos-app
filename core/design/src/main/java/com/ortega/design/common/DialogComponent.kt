package com.ortega.design.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.Dialog
import com.ortega.design.R
import com.ortega.design.theme.Blue
import com.ortega.design.theme.Gray
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

@Composable
fun DialogComponent(
    title: String,
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
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = Padding),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        TextButton(
                            onClick = { setShowDialog(false) }
                        ) {
                            TextComponent(text = stringResource(R.string.back), color = Gray)
                        }
                        
                        WidthSpacer(width = Padding / 8)
                        
                        TextButton(onClick = { onClick() }) {
                            TextComponent(text = stringResource(R.string.delete), color = Blue)
                        }
                    }
                    HeightSpacer(height = Padding)
                }
            }
        }
    }

}