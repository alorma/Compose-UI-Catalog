package com.alorma.compose_catalog

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

@Composable
fun CatalogScreen(
    isDark: Boolean = isSystemInDarkTheme(),
    lightColors: Colors = MaterialTheme.colors,
    darkColors: Colors = MaterialTheme.colors,
    shapes: Shapes = MaterialTheme.shapes,
    typography: Typography = MaterialTheme.typography,
    items: List<CatalogItem> = emptyList()
) {
    val colors = if (isDark) darkColors else lightColors

    MaterialTheme(
        colors = colors,
        shapes = shapes,
        typography = typography
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(asset = vectorResource(id = R.drawable.ic_catalog_palette))
                            Spacer(modifier = Modifier.preferredWidth(8.dp))
                            Text(text = "Catalog")
                        }
                    }
                )
            }
        ) {
            CatalogItemsContent(MaterialCatalogItems() + items)
        }
    }
}

@Composable
private fun CatalogItemsContent(list: List<CatalogItem>) {
    LazyColumnFor(
        items = list,
    ) { item ->

        var expanded: Boolean by remember { mutableStateOf(false) }

        Column {
            catalogItemTitle(
                item = item,
                expanded = expanded,
                onClick = { expanded = !expanded }
            )
            if (expanded) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    item.builder()
                }
            }
        }
    }
}

@Composable
private fun catalogItemTitle(
    item: CatalogItem,
    expanded: Boolean,
    onClick: () -> Unit,
) {
    val surfaceColor = if (isSystemInDarkTheme()) {
        MaterialTheme.colors.secondary.copy(alpha = 0.20f).compositeOver(
            MaterialTheme.colors.background
        )
    } else {
        MaterialTheme.colors.secondary
    }
    val contentColor = MaterialTheme.colors.onSecondary

    Surface(
        color = surfaceColor,
        contentColor = contentColor,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clickable(onClick = onClick)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(vectorResource(id = item.icon))
            Spacer(modifier = Modifier.preferredWidth(8.dp))
            ProvideTextStyle(value = MaterialTheme.typography.h5) {
                Text(text = item.name)
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DebugCatalogPreview() {
    CatalogScreen()
}