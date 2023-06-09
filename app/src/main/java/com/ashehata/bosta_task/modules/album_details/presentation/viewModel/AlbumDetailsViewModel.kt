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
                val photos = getPhotosUseCase.execute(albumId = args.id).map { it.toUIModel() }
                it.filteredPhotos.clear()
                it.filteredPhotos.addAll(photos)
                it.allPhotos.addAll(photos)
            }
        }
    }

    override fun handleEvents(event: AlbumDetailsEvent) {
        when (event) {
            is AlbumDetailsEvent.OnPhotoClicked -> setState {
                AlbumDetailsState.OpenImageViewerScreen(event.url)
            }
            is AlbumDetailsEvent.OnSearch -> {
                if (event.name.trim().isEmpty()) {
                    viewStates?.filteredPhotos?.clear()
                    viewStates?.filteredPhotos?.addAll(viewStates?.allPhotos ?: emptyList())
                } else {
                    val resultPhotos =
                        viewStates?.allPhotos?.filter { it?.title?.contains(event.name) ?: false }
                            ?: emptyList()

                    viewStates?.filteredPhotos?.clear()
                    viewStates?.filteredPhotos?.addAll(resultPhotos)
                }

            }
        }
    }

    override fun createInitialViewState(): AlbumDetailsViewState {
        return AlbumDetailsViewState()
    }
}