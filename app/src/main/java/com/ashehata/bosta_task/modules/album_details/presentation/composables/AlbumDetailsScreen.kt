package com.ashehata.bosta_task.modules.album_details.presentation.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.ashehata.bosta_task.modules.album_details.presentation.args.AlbumDetailsScreenNavArgs
import com.ashehata.bosta_task.modules.album_details.presentation.contract.AlbumDetailsEvent
import com.ashehata.bosta_task.modules.album_details.presentation.contract.AlbumDetailsViewState
import com.ashehata.bosta_task.modules.album_details.presentation.viewModel.AlbumDetailsViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Composable
@Destination(navArgsDelegate = AlbumDetailsScreenNavArgs::class)
fun AlbumDetailsScreen(
    navigator: DestinationsNavigator,
    viewModel: AlbumDetailsViewModel = hiltViewModel()
) {
    val viewStates = remember {
        viewModel.viewStates ?: AlbumDetailsViewState()
    }

    val photos = remember {
        viewStates.photos
    }

    val albumName = remember {
        viewStates.albumName
    }

    val onPhotoClicked: (String?) -> Unit = remember {
        {
            viewModel.setEvent(AlbumDetailsEvent.OpenPhotoViewerScreen(it))
        }
    }


    AlbumDetailsScreenContent(
        albumName = albumName,
        photos = photos,
        onPhotoClicked = onPhotoClicked
    )

}