package com.ashehata.bosta_task.modules.album_details.presentation.viewModel

import androidx.lifecycle.SavedStateHandle
import com.ashehata.bosta_task.base.BaseViewModel
import com.ashehata.bosta_task.modules.album_details.domain.usecase.GetPhotosUseCase
import com.ashehata.bosta_task.modules.album_details.presentation.contract.AlbumDetailsEvent
import com.ashehata.bosta_task.modules.album_details.presentation.contract.AlbumDetailsState
import com.ashehata.bosta_task.modules.album_details.presentation.contract.AlbumDetailsViewState
import com.ashehata.bosta_task.modules.album_details.presentation.mapper.toUIModel
import com.ashehata.bosta_task.modules.destinations.AlbumDetailsScreenDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlbumDetailsViewModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase,
    private val savedStateHandle: SavedStateHandle
) : BaseViewModel<AlbumDetailsEvent, AlbumDetailsViewState, AlbumDetailsState>() {

    init {
        launchCoroutine {
            viewStates?.let {
                val args = AlbumDetailsScreenDestination.argsFrom(savedStateHandle)
                it.albumName = args.albumName
                it.photos.clear()
                it.photos.addAll(getPhotosUseCase.execute(albumId = args.id).map { it.toUIModel() })
            }
        }
    }

    override fun handleEvents(event: AlbumDetailsEvent) {
        when (event) {
            is AlbumDetailsEvent.OpenPhotoViewerScreen -> setState {
                AlbumDetailsState.OpenAlbumDetailsScreen(event.url)
            }
        }
    }

    override fun createInitialViewState(): AlbumDetailsViewState {
        return AlbumDetailsViewState()
    }
}