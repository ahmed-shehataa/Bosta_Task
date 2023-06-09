package com.ashehata.bosta_task.modules.album_details.presentation.contract

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.ashehata.bosta_task.base.BaseEvent
import com.ashehata.bosta_task.base.BaseState
import com.ashehata.bosta_task.base.BaseViewState
import com.ashehata.bosta_task.modules.album_details.presentation.model.PhotoUIModel

sealed class AlbumDetailsEvent : BaseEvent {
    data class OpenPhotoViewerScreen(val url: String?) : AlbumDetailsEvent()
}

sealed class AlbumDetailsState : BaseState {
    class OpenAlbumDetailsScreen(val url: String?) : AlbumDetailsState()
}

data class AlbumDetailsViewState(
    override val networkError: MutableState<Boolean> = mutableStateOf(false),
    override val isRefreshing: MutableState<Boolean> = mutableStateOf(false),
    val photos: MutableList<PhotoUIModel?> = SnapshotStateList(),
    var albumName: String = ""
) : BaseViewState
