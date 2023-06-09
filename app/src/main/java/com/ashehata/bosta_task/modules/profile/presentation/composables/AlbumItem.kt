package com.ashehata.bosta_task.modules.profile.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ashehata.bosta_task.modules.profile.presentation.model.AlbumUIModel


@Composable
fun AlbumItem(
    albumModel: AlbumUIModel,
    hasDivider: Boolean,
    onAlbumClicked: (Int) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onAlbumClicked(albumModel.id ?: -1)
                }
                .padding(vertical = 8.dp, horizontal = 20.dp),
            text = albumModel.title ?: "",
            style = MaterialTheme.typography.body1.copy(
                color = MaterialTheme.colors.onSecondary
            )
        )

        if (hasDivider)
            Divider(color = MaterialTheme.colors.onSecondary.copy(alpha = .2f))

    }

}