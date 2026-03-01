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
    tertiary = Color(57, 102, 97),
    onTertiary = Color(255, 255, 255),
    tertiaryContainer = Color(188, 236, 229),
    onTertiaryContainer = Color(0, 32, 29),
    background = Color(246, 250, 254),
    onBackground = Color(23, 28, 31),
    surface = Color(246, 250, 254),
    onSurface = Color(23, 28, 31),
    surfaceVariant = Color(222, 227, 230),
    onSurfaceVariant = Color(66, 72, 74),
    surfaceTint = Color(0, 98, 157),
    inverseSurface = Color(44, 49, 52),
    inverseOnSurface = Color(237, 241, 245),
    error = Color(179, 40, 35),
    onError = Color(255, 255, 255),
    errorContainer = Color(255, 218, 214),
    onErrorContainer = Color(65, 0, 2),
    outline = Color(115, 120, 123),
    outlineVariant = Color(194, 199, 202),
    scrim = Color(0, 0, 0),
    surfaceBright = Color(246, 250, 254),
    surfaceContainer = Color(234, 238, 242),
    surfaceContainerHigh = Color(229, 233, 237),
    surfaceContainerHighest = Color(223, 227, 231),
    surfaceContainerLow = Color(240, 244, 248),
    surfaceContainerLowest = Color(255, 255, 255),
    surfaceDim = Color(214, 218, 222),
    primaryFixed = Color(208, 228, 253),
    primaryFixedDim = Color(137, 208, 242),
    onPrimaryFixed = Color(0, 31, 42),
    onPrimaryFixedVariant = Color(0, 77, 101),
    secondaryFixed = Color(213, 228, 247),
    secondaryFixedDim = Color(185, 200, 218),
    onSecondaryFixed = Color(14, 29, 42),
    onSecondaryFixedVariant = Color(58, 72, 87),
    tertiaryFixed = Color(188, 236, 229),
    tertiaryFixedDim = Color(160, 208, 202),
    onTertiaryFixed = Color(0, 32, 29),
    onTertiaryFixedVariant = Color(31, 78, 74)
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
    onSecondaryContainer = Color(213, 228, 247),
    tertiary = Color(160, 208, 202),
    onTertiary = Color(0, 55, 52),
    tertiaryContainer = Color(31, 78, 74),
    onTertiaryContainer = Color(188, 236, 230),
    background = Color(16, 20, 22),
    onBackground = Color(224, 227, 230),
    surface = Color(16, 20, 22),
    onSurface = Color(224, 227, 230),
    surfaceVariant = Color(65, 72, 75),
    onSurfaceVariant = Color(193, 200, 204),
    surfaceTint = Color(137, 208, 242),
    inverseSurface = Color(223, 227, 231),
    inverseOnSurface = Color(44, 49, 52),
    error = Color(255, 180, 171),
    onError = Color(105, 0, 5),
    errorContainer = Color(145, 10, 14),
    onErrorContainer = Color(255, 218, 214),
    outline = Color(138, 146, 151),
    outlineVariant = Color(64, 72, 76),
    scrim = Color(0, 0, 0),
    surfaceBright = Color(53, 58, 61),
    surfaceContainer = Color(27, 32, 35),
    surfaceContainerHigh = Color(38, 43, 46),
    surfaceContainerHighest = Color(48, 53, 56),
    surfaceContainerLow = Color(23, 28, 31),
    surfaceContainerLowest = Color(10, 15, 18),
    surfaceDim = Color(15, 20, 23),
    primaryFixed = Color(208, 228, 253),
    primaryFixedDim = Color(137, 208, 242),
    onPrimaryFixed = Color(0, 31, 42),
    onPrimaryFixedVariant = Color(0, 77, 101),
    secondaryFixed = Color(213, 228, 247),
    secondaryFixedDim = Color(185, 200, 218),
    onSecondaryFixed = Color(14, 29, 42),
    onSecondaryFixedVariant = Color(58, 72, 87),
    tertiaryFixed = Color(188, 236, 229),
    tertiaryFixedDim = Color(160, 208, 202),
    onTertiaryFixed = Color(0, 32, 29),
    onTertiaryFixedVariant = Color(31, 78, 74)
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