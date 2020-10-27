package com.alorma.composecatalog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import com.alorma.compose_catalog.CatalogScreen
import com.alorma.composecatalog.ui.ComposeCatalogTheme
import com.alorma.composecatalog.ui.DarkColorPalette
import com.alorma.composecatalog.ui.LightColorPalette

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeCatalogTheme {
                CatalogScreen(
                    lightColors = LightColorPalette,
                    darkColors = DarkColorPalette,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LightDefaultPreview() {
    ComposeCatalogTheme {
        CatalogScreen(
            lightColors = LightColorPalette,
            darkColors = DarkColorPalette,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DarkDefaultPreview() {
    ComposeCatalogTheme {
        CatalogScreen(
            isDark = true,
            lightColors = LightColorPalette,
            darkColors = DarkColorPalette,
        )
    }
}