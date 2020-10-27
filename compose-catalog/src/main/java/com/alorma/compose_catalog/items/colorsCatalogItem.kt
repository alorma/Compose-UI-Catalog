package com.alorma.compose_catalog.items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun colorsCatalogItem() {
    val colors = listOf(
        Triple(
            "primary",
            MaterialTheme.colors.primary,
            MaterialTheme.colors.onPrimary,
        ),
        Triple(
            "primaryVariant",
            MaterialTheme.colors.primaryVariant,
            MaterialTheme.colors.onPrimary,
        ),
        Triple(
            "secondary",
            MaterialTheme.colors.secondary,
            MaterialTheme.colors.onSecondary,
        ),
        Triple(
            "secondaryVariant",
            MaterialTheme.colors.secondaryVariant,
            MaterialTheme.colors.onSecondary,
        ),
        Triple(
            "background",
            MaterialTheme.colors.background,
            MaterialTheme.colors.onBackground,
        ),
        Triple(
            "surface",
            MaterialTheme.colors.surface,
            MaterialTheme.colors.onSurface,
        ),
        Triple(
            "error",
            MaterialTheme.colors.error,
            MaterialTheme.colors.onError,
        ),
        Triple(
            "onPrimary",
            MaterialTheme.colors.onPrimary,
            MaterialTheme.colors.primary,
        ),
        Triple(
            "onSecondary",
            MaterialTheme.colors.onSecondary,
            MaterialTheme.colors.secondary,
        ),
        Triple(
            "onBackground",
            MaterialTheme.colors.onBackground,
            MaterialTheme.colors.background,
        ),
        Triple(
            "onSurface",
            MaterialTheme.colors.onSurface,
            MaterialTheme.colors.surface,
        ),
        Triple(
            "onError",
            MaterialTheme.colors.onError,
            MaterialTheme.colors.error,
        ),
    )

    Column {
        colors.forEachIndexed { index, (name, color, onColor) ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .preferredHeight(36.dp)
                    .clip(shape = MaterialTheme.shapes.medium)
                    .background(color = color)
                    .border(
                        border = BorderStroke(1.dp, color = onColor),
                        shape = MaterialTheme.shapes.medium
                    ),
                alignment = Alignment.Center,
            ) {
                Text(
                    text = name,
                    color = onColor
                )
            }
            if (index < colors.size - 1) {
                Spacer(modifier = Modifier.preferredHeight(8.dp))
            }
        }
    }
}