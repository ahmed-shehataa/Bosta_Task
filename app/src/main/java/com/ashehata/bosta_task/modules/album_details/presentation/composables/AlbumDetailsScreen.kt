package com.ashehata.bosta_task.modules.album_details.presentation.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.ashehata.bosta_task.common.presentation.GeneralObservers
import com.ashehata.bosta_task.modules.album_details.presentation.args.AlbumDetailsScreenNavArgs
import com.ashehata.bosta_task.modules.album_details.presentation.contract.AlbumDetailsEvent
import com.ashehata.bosta_task.modules.album_details.presentation.contract.AlbumDetailsState
import com.ashehata.bosta_task.modules.album_details.presentation.contract.AlbumDetailsViewState
import com.ashehata.bosta_task.modules.album_details.presentation.viewModel.AlbumDetailsViewModel
import com.ashehata.bosta_task.modules.destinations.ImageViewerScreenDestination
import com.ashehata.bosta_task.modules.image_viewer.args.ImageViewerScreenNavArgs
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
        viewStates.filteredPhotos
    }

    val albumName = remember {
        viewStates.albumName
    }

    val searchTextState = remember {
        viewStates.searchTextState
    }

    val onPhotoClicked: (String?) -> Unit = remember {
        {
            viewModel.setEvent(AlbumDetailsEvent.OnPhotoClicked(it))
        }
    }

    val onSearch: (String) -> Unit = remember {
        {
            viewModel.setEvent(AlbumDetailsEvent.OnSearch(it))
        }
    }


    val onBackPressed: () -> Unit = remember {
        {
            navigator.popBackStack()
        }
    }


    AlbumDetailsScreenContent(
        albumName = albumName,
        photos = photos,
        searchTextState = searchTextState,
        onPhotoClicked = onPhotoClicked,
        onBackPressed = onBackPressed,
        onSearch = onSearch
    )

    GeneralObservers<AlbumDetailsState, AlbumDetailsViewModel>(viewModel = viewModel) {
        when (it) {
            is AlbumDetailsState.OpenImageViewerScreen -> {
                navigator.navigate(
                    ImageViewerScreenDestination(ImageViewerScreenNavArgs(it.url))
                )
            }
        }
    }

}