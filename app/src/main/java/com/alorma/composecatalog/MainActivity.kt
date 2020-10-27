package com.alorma.composecatalog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import com.alorma.compose_catalog.CatalogScreen
import com.alorma.composecatalog.ui.themePurple
import com.alorma.composecatalog.ui.themeTriadic

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CatalogScreen(
                themes = listOf(
                    themeTriadic,
                    themePurple,
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LightDefaultPreview() {
    CatalogScreen()
}