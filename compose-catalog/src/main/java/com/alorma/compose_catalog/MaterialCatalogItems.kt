package com.alorma.compose_catalog

import com.alorma.compose_catalog.items.colorsCatalogItem
import com.alorma.compose_catalog.items.typographyCatalogItem

object MaterialCatalogItems {

    operator fun invoke(): List<CatalogItem> = listOf(
        CatalogItem(R.drawable.ic_catalog_fonts, "Fonts") {
            typographyCatalogItem()
        },
        CatalogItem(R.drawable.ic_catalog_color, "Colors") {
            colorsCatalogItem()
        }
    )
}
