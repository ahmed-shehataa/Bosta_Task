package com.ashehata.bosta_task.modules.album_details.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import com.ashehata.bosta_task.common.presentation.AppBar
import com.ashehata.bosta_task.modules.album_details.presentation.model.PhotoUIModel


@Composable
fun AlbumDetailsScreenContent(
    photos: List<PhotoUIModel?>,
    onPhotoClicked: (String?) -> Unit,
    albumName: String
) {

    Column {

        AppBar(
            title = albumName,
            extraBody = {

            }
        )


        LazyVerticalGrid(columns = GridCells.Fixed(3)) {

            items(
                items = photos,
                key = { item: PhotoUIModel? ->
                    item?.id ?: -1
                },
            ) { photo ->
                PhotoItem(photo, onPhotoClicked)
            }

        }
    }


}