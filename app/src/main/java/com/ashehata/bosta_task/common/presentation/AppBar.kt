package com.ashehata.bosta_task.common.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    title: String,
    hasSearchBar: Boolean = false,
    hasDivider: Boolean = false,
    extraBody: @Composable (ColumnScope) -> Unit = {}
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {

        Text(
            text = title,
            style = MaterialTheme.typography.subtitle1.copy(
                color = MaterialTheme.colors.onSecondary
            )
        )

        if (hasDivider)
            Divider(color = MaterialTheme.colors.onSecondary.copy(alpha = .2f))

        extraBody(this)
    }
}