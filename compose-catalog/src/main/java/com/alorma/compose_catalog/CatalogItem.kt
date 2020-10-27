package com.alorma.compose_catalog

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable

data class CatalogItem(
    @DrawableRes val icon: Int,
    val name: String,
    val builder: @Composable () -> Unit
)