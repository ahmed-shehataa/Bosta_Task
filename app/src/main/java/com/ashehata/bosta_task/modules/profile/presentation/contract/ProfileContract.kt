package com.ashehata.bosta_task.modules.profile.presentation.contract

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.ashehata.bosta_task.base.BaseEvent
import com.ashehata.bosta_task.base.BaseState
import com.ashehata.bosta_task.base.BaseViewState
import com.ashehata.bosta_task.modules.profile.presentation.model.AlbumUIModel
import com.ashehata.bosta_task.modules.profile.presentation.model.UserUIModel

sealed class ProfileEvent : BaseEvent {
    data class OpenAlbumDetailsScreen(val id: Int) : ProfileEvent()
}

sealed class ProfileState : BaseState {
    class OpenAlbumDetailsScreen(val id: Int) : ProfileState()
}

data class ProfileViewState(
    override val networkError: MutableState<Boolean> = mutableStateOf(false),
    override val isRefreshing: MutableState<Boolean> = mutableStateOf(false),
    val user: MutableState<UserUIModel?> = mutableStateOf(
        null
    ),
    val albums: MutableList<AlbumUIModel?> = SnapshotStateList()
) : BaseViewState
