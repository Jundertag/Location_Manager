package com.jayden.locationmanager.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightTheme = lightColorScheme(
    primary = Color(0, 98, 157),
    onPrimary = Color(255, 255, 255),
    primaryContainer = Color(208, 228, 253),
    onPrimaryContainer = Color(0, 29, 52),
    inversePrimary = Color(155, 203, 253),
    secondary = Color(82, 96, 112),
    onSecondary = Color(14, 29, 42),
    secondaryContainer = Color(213, 228, 247),
    onSecondaryContainer = Color(14, 29, 42),
)
private val DarkTheme = darkColorScheme(
    primary = Color(137, 208, 242),
    onPrimary = Color(0, 51, 85),
    primaryContainer = Color(53, 72, 92),
    onPrimaryContainer = Color(208, 228, 253),
    inversePrimary = Color(0, 98, 157),
    secondary = Color(185, 200, 218),
    onSecondary = Color(36, 50, 64),
    secondaryContainer = Color(58, 72, 87),
    onSecondaryContainer = Color(213, 228, 247)
)

@Composable
fun AppTheme(
    content: @Composable (() -> Unit)
) {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) DarkTheme else LightTheme
    ) {
        content()
    }
}