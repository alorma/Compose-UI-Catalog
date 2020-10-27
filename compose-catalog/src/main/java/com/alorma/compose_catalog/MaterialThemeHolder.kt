package com.alorma.compose_catalog

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable

data class MaterialThemeHolder(
    val name: String,
    val lightColors: Colors,
    val darkColors: Colors,
    val shapes: Shapes,
    val typography: Typography
) {

    @Composable
    fun compile(
        isDark: Boolean = isSystemInDarkTheme(),
        content: @Composable () -> Unit,
    ) {
        MaterialTheme(
            colors = if (isDark) darkColors else lightColors,
            shapes = shapes,
            typography = typography,
            content = content,
        )
    }
}