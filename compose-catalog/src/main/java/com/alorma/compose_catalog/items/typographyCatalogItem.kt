package com.alorma.compose_catalog.items

import androidx.compose.foundation.ProvideTextStyle
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.foundation.lazy.ExperimentalLazyDsl
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLazyDsl::class)
@Composable
fun typographyCatalogItem() {
    val fonts = listOf(
        "h1" to MaterialTheme.typography.h1,
        "h2" to MaterialTheme.typography.h2,
        "h3" to MaterialTheme.typography.h3,
        "h4" to MaterialTheme.typography.h4,
        "h5" to MaterialTheme.typography.h5,
        "h6" to MaterialTheme.typography.h6,
        "subtitle1" to MaterialTheme.typography.subtitle1,
        "subtitle2" to MaterialTheme.typography.subtitle2,
        "body1" to MaterialTheme.typography.body1,
        "body2" to MaterialTheme.typography.body2,
        "button" to MaterialTheme.typography.button,
        "caption" to MaterialTheme.typography.caption,
        "overline" to MaterialTheme.typography.overline,
    )

    Column {
        fonts.forEachIndexed { index, (name, textStyle) ->
            Row {
                ProvideTextStyle(value = textStyle) {
                    Text(text = name)
                }
            }
            if (index < fonts.size - 1) {
                Spacer(modifier = Modifier.preferredSize(4.dp))
                fontDivider()
                Spacer(modifier = Modifier.preferredSize(4.dp))
            }

        }
    }
}

@Composable
private fun fontDivider() {
    Divider(
        color = MaterialTheme.colors.onBackground.copy(alpha = 0.12f).compositeOver(
            MaterialTheme.colors.background
        )
    )
}