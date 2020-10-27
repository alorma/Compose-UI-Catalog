package com.alorma.compose_catalog

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CatalogScreen(
    themes: List<MaterialThemeHolder> = listOf(
        MaterialThemeHolder(
            name = "Default",
            lightColors = MaterialTheme.colors,
            darkColors = MaterialTheme.colors,
            shapes = MaterialTheme.shapes,
            typography = MaterialTheme.typography,
        )
    ),
    items: List<CatalogItem> = emptyList()
) {
    var selectedTheme: MaterialThemeHolder by remember { mutableStateOf(themes.first()) }

    var selectThemeDialog: Boolean by remember { mutableStateOf(false) }

    selectedTheme.compile(isDark = isSystemInDarkTheme()) {
        Scaffold(
            topBar = {
                CatalogToolbar(
                    selectedTheme = selectedTheme,
                    onChangeThemeClicked = {
                        selectThemeDialog = true
                    }
                )
            }
        ) {
            CatalogItemsContent(MaterialCatalogItems() + items)
            if (selectThemeDialog) {
                showThemeSelector(
                    themes = themes,
                    onThemeSelected = { theme ->
                        selectThemeDialog = false
                        selectedTheme = theme
                    }
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun showThemeSelector(
    themes: List<MaterialThemeHolder>,
    onThemeSelected: (MaterialThemeHolder) -> Unit,
) {
    val drawerShape = RoundedCornerShape(
        topLeft = 16.dp,
        topRight = 16.dp,
        bottomLeft = 0.dp,
        bottomRight = 0.dp
    )

    var drawerState = rememberBottomDrawerState(BottomDrawerValue.Open)

    BottomDrawerLayout(
        drawerShape = drawerShape,
        drawerState = drawerState,
        drawerContent = {
            LazyColumnFor(items = themes) { theme ->
                val colors = if (isSystemInDarkTheme()) {
                    theme.darkColors
                } else {
                    theme.lightColors
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(48.dp)
                        .clip(shape = theme.shapes.medium)
                        .clickable(onClick = {
                            drawerState.close()
                            onThemeSelected(theme)
                        })
                        .padding(8.dp)
                ) {
                    Icon(
                        tint = colors.primary,
                        asset = vectorResource(id = R.drawable.ic_catalog_palette)
                    )
                    Spacer(modifier = Modifier.preferredWidth(8.dp))
                    ProvideTextStyle(value = MaterialTheme.typography.h5) {
                        Text(text = theme.name)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }) {

    }
}

@Composable
private fun CatalogToolbar(
    selectedTheme: MaterialThemeHolder,
    onChangeThemeClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Column {
                Text(text = "Catalog")
                Text(text = selectedTheme.name)
            }
        },
        actions = {
            IconButton(
                icon = { Icon(asset = vectorResource(id = R.drawable.ic_catalog_palette)) },
                onClick = onChangeThemeClicked,
            )
        }
    )
}

@Composable
private fun CatalogItemsContent(list: List<CatalogItem>) {
    LazyColumnFor(
        items = list,
        contentPadding = PaddingValues(
            bottom = 32.dp
        )
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
                        .padding(
                            top = 4.dp,
                            start = 16.dp,
                            bottom = 4.dp,
                            end = 16.dp
                        )
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
    val surfaceColor = MaterialTheme.colors.onSurface.copy(alpha = 0.12f)
        .compositeOver(MaterialTheme.colors.surface)

    val shape = if (expanded) {
        MaterialTheme.shapes.medium
    } else {
        RoundedCornerShape(0.dp)
    }

    Surface(
        color = surfaceColor,
        shape = shape,
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = shape)
            .padding(if (expanded) 8.dp else 0.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(48.dp)
                .clip(shape = shape)
                .clickable(onClick = onClick)
                .padding(8.dp)
        ) {
            Icon(vectorResource(id = item.icon))
            Spacer(modifier = Modifier.preferredWidth(8.dp))
            ProvideTextStyle(value = MaterialTheme.typography.h5) {
                Text(text = item.name)
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DebugCatalogPreview() {
    CatalogScreen()
}