package com.alorma.compose_catalog.items

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.alorma.compose_catalog.R

@Composable
fun buttonsCatalogItem() {
    Column {
        Text(text = "Primary")
        Spacer(modifier = Modifier.preferredHeight(4.dp))
        buttonsContent(MaterialTheme.colors.primary)
        Spacer(modifier = Modifier.preferredHeight(12.dp))

        Text(text = "Secondary")
        Spacer(modifier = Modifier.preferredHeight(4.dp))
        buttonsContent(MaterialTheme.colors.secondary)
        Spacer(modifier = Modifier.preferredHeight(12.dp))

        Text(text = "Error")
        Spacer(modifier = Modifier.preferredHeight(4.dp))
        buttonsContent(MaterialTheme.colors.error)
        Spacer(modifier = Modifier.preferredHeight(12.dp))
    }
}

@Composable
private fun buttonsContent(color: Color) {
    Button(
        backgroundColor = color,
        modifier = Modifier.fillMaxWidth(),
        onClick = {}) {
        Text(text = "Contained Button")
    }
    Spacer(modifier = Modifier.preferredHeight(8.dp))
    TextButton(
        contentColor = color,
        modifier = Modifier.fillMaxWidth(),
        onClick = {},
    ) {
        Text(text = "Text button")
    }
    Spacer(modifier = Modifier.preferredHeight(8.dp))
    OutlinedButton(
        contentColor = color,
        modifier = Modifier.fillMaxWidth(),
        onClick = {}) {
        Text(text = "Outlined button")
    }
    Spacer(modifier = Modifier.preferredHeight(8.dp))
    FloatingActionButton(
        onClick = {},
        backgroundColor = color,
    ) {
        Icon(vectorResource(id = R.drawable.ic_catalog_add))
    }
    Spacer(modifier = Modifier.preferredHeight(8.dp))
    ExtendedFloatingActionButton(
        backgroundColor = color,
        text = { Text(text = "Extended") },
        onClick = {},
        icon = { Icon(vectorResource(id = R.drawable.ic_catalog_add)) },
    )
}