package com.ashehata.bosta_task.modules.album_details.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import com.ashehata.bosta_task.common.presentation.compose.AppBar
import com.ashehata.bosta_task.common.presentation.compose.HeaderShadow
import com.ashehata.bosta_task.common.presentation.compose.SearchView
import com.ashehata.bosta_task.modules.album_details.presentation.model.PhotoUIModel


@Composable
fun AlbumDetailsScreenContent(
    photos: List<PhotoUIModel?>,
    onPhotoClicked: (String?) -> Unit,
    albumName: String,
    onBackPressed: () -> Unit,
    onSearch: (String) -> Unit,
    searchTextState: MutableState<TextFieldValue>,
) {

    Column {

        HeaderShadow {
            AppBar(
                title = albumName,
                hasBackButton = true,
                onBackPressed = onBackPressed,
                extraBody = {
                    SearchView(searchTextState, onSearch)
                }
            )
        }

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