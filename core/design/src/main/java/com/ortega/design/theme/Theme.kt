package com.ortega.design.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

internal val LightColorScheme = lightColorScheme(
    primary = Black,
    secondary = Black,
    background = Black,
    surface = Black
)

internal val DarkColorScheme = darkColorScheme(
    primary = Black,
    secondary = Black,
    background = Black,
    surface = Black
)

@Composable
fun PosAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme
    val view = LocalView.current
    val window = (view.context as Activity).window
    window.statusBarColor = colorScheme.primary.toArgb()
    window.navigationBarColor = colorScheme.primary.toArgb()
    WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}