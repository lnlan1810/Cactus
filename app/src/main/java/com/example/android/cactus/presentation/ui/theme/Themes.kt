package com.example.android.cactus.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val lightTheme = lightColors(
    primary = Color(0xFF617BF4),
    primaryVariant = Color(0xFF3700b3),
    secondary = Color(0xFF7C61F4),
    secondaryVariant = Color(0xFF5F00B3),
    background = Color(0xFFF5F8FE),
    surface = Color(0xFFFFFFFF),
    error = Color(0xFFD53F3F),
    onPrimary = Color(0xFFF1F1F1),
    onBackground = Color(0xFF1E1E1E),
    onSecondary = Color(0xFF192038),
    onSurface = Color(0xFF1E1E1E),
    onError = Color(0xFFFFFFFF),
)

val darkTheme = darkColors(
    primary = Color(0xFF617BF4),
    primaryVariant = Color(0xFF1D005E),
    secondary = Color(0xFF0A6ABD),
    secondaryVariant = Color(0xFF025988),
    background = Color(0xFF181818),
    surface = Color(0xFF2C2C2C),
    error = Color(0xFFCF6679),
    onPrimary = Color(0xFF000000),
    onBackground = Color(0xFFE2E2E2),
    onSecondary = Color(0xFFF1F1F1),
    onSurface = Color(0xFFE2E2E2),
    onError = Color(0xFFF1F1F1),
)


private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200,
    onBackground = LightGray
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200,
)

@Composable
fun DictionaryTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}