package com.ortega.design.auth

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ortega.design.common.TextComponent
import com.ortega.design.theme.Padding
import com.ortega.design.theme.White

@Composable
fun HeaderTextComponent(text: String) {

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Padding)
    ) {

        TextComponent(text = text, color = White)

    }

}