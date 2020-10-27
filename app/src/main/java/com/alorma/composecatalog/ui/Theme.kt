package com.alorma.composecatalog.ui

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color
import com.alorma.compose_catalog.MaterialThemeHolder

val themePurple = MaterialThemeHolder(
    name = "Purple",
    lightColors = lightColors(
        primary = purple700,
        primaryVariant = purple700,
        onPrimary = Color.White,
        secondary = teal200,
        onSecondary = Color.Black,
    ),
    darkColors = darkColors(
        primary = purple200,
        primaryVariant = purple700,
        onPrimary = Color.White,
        secondary = teal200,
        onSecondary = Color.Black
    ),
    shapes = shapes,
    typography = typography
)

val themeTriadic = MaterialThemeHolder(
    name = "Triadic",
    lightColors = lightColors(
        primary = triadic600,
        primaryVariant = triadic600,
        onPrimary = Color.White,
        secondary = orange100,
        onSecondary = Color.Black,
    ),
    darkColors = darkColors(
        primary = triadic600,
        primaryVariant = triadic600,
        onPrimary = Color.White,
        secondary = orange100,
        onSecondary = Color.Black
    ),
    shapes = shapes,
    typography = typography
)