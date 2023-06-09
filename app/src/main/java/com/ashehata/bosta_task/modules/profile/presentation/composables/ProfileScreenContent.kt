package com.ashehata.bosta_task.modules.profile.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ashehata.bosta_task.R
import com.ashehata.bosta_task.common.presentation.compose.AppBar
import com.ashehata.bosta_task.common.presentation.compose.HeaderShadow
import com.ashehata.bosta_task.modules.profile.presentation.model.AlbumUIModel
import com.ashehata.bosta_task.modules.profile.presentation.model.UserUIModel


@Composable
fun ProfileScreenContent(
    user: UserUIModel?,
    albums: List<AlbumUIModel?>,
    onAlbumClicked: (AlbumUIModel) -> Unit
) {

    Column {

        HeaderShadow {
            AppBar(
                Modifier.padding(
                    top = 12.dp,
                    end = 20.dp,
                    start = 20.dp
                ),
                title = stringResource(id = R.string.profile),
                extraBody = {
                    Text(
                        text = user?.name ?: "",
                        style = MaterialTheme.typography.body1.copy(
                            color = MaterialTheme.colors.onSecondary
                        )
                    )
                    Text(
                        text = user?.address ?: "",
                        style = MaterialTheme.typography.body1.copy(
                            color = MaterialTheme.colors.onSecondary
                        )
                    )
                },
            )
        }


        LazyColumn {

            itemsIndexed(albums) { index, album ->
                album?.let {
                    AlbumItem(
                        albumModel = album,
                        hasDivider = albums.lastIndex != index,
                        onAlbumClicked = onAlbumClicked
                    )
                }
            }
        }


    }
}