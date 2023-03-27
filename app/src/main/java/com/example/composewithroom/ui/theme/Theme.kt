package com.example.composewithroom.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette =
    darkColors(primary = primary,
        primaryVariant = primary,
        secondary = Teal200,
        background = background,
        surface = surface)

private val LightColorPalette =
    lightColors(primary = primary,
        primaryVariant = primary,
        secondary = Teal200,
        background = background,
        surface = surface)

@Composable
fun ComposeWithRoomTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(colors = colors, typography = Typography, shapes = Shapes, content = content)
}