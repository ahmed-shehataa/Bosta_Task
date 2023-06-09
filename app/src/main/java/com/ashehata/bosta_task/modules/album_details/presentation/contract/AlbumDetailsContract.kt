package com.ashehata.bosta_task.modules.album_details.presentation.contract

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.text.input.TextFieldValue
import com.ashehata.bosta_task.base.BaseEvent
import com.ashehata.bosta_task.base.BaseState
import com.ashehata.bosta_task.base.BaseViewState
import com.ashehata.bosta_task.modules.album_details.presentation.model.PhotoUIModel

sealed class AlbumDetailsEvent : BaseEvent {
    data class OnPhotoClicked(val url: String?) : AlbumDetailsEvent()
    data class OnSearch(val name: String) : AlbumDetailsEvent()
}

sealed class AlbumDetailsState : BaseState {
    data class OpenImageViewerScreen(val url: String?) : AlbumDetailsState()
}

data class AlbumDetailsViewState(
    override val isNetworkError: MutableState<Boolean> = mutableStateOf(false),
    override val isRefreshing: MutableState<Boolean> = mutableStateOf(false),
    override val isLoading: MutableState<Boolean> = mutableStateOf(false),
    val allPhotos: MutableList<PhotoUIModel?> = SnapshotStateList(),
    val filteredPhotos: MutableList<PhotoUIModel?> = SnapshotStateList(),
    val searchTextState: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue()),
    var albumName: String = ""
) : BaseViewState
