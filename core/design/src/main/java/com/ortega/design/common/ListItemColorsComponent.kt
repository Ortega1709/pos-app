package com.ortega.design.common

import androidx.compose.material3.ListItemColors
import androidx.compose.material3.ListItemDefaults
import androidx.compose.runtime.Composable
import com.ortega.design.theme.Gray
import com.ortega.design.theme.White

@Composable
fun listItemColorsComponent(): ListItemColors {

    return ListItemDefaults.colors(
        supportingColor = White,
        headlineColor = White,
        overlineColor = Gray
    )

}