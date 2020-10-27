package com.alorma.composecatalog.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val DarkColorPalette = darkColors(
    primary = purple200,
    primaryVariant = purple700,
    onPrimary = Color.White,
    secondary = teal200,
    onSecondary = Color.Black
)

val LightColorPalette = lightColors(
    primary = purple500,
    primaryVariant = purple700,
    onPrimary = Color.White,
    secondary = teal200,
    onSecondary = Color.Black,
)

@Composable
fun ComposeCatalogTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}