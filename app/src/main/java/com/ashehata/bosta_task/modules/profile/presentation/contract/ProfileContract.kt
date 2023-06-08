package com.ashehata.bosta_task.modules.profile.presentation.contract

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.ashehata.bosta_task.base.BaseEvent
import com.ashehata.bosta_task.base.BaseState
import com.ashehata.bosta_task.base.BaseViewState

sealed class ProfileEvent : BaseEvent {
    data class OpenAlbumDetailsScreen(val id: Int) : ProfileEvent()
}

sealed class ProfileState : BaseState {
    class OpenAlbumDetailsScreen(val id: Int) : ProfileState()
}

data class ProfileViewState(
    override val networkError: MutableState<Boolean> = mutableStateOf(false),
    override val isRefreshing: MutableState<Boolean> = mutableStateOf(false),
    /*val user: MutableState<UserUIModel?> = mutableStateOf(
        null
    ),
    val firstLayoutHeight: MutableState<Int> = mutableStateOf(400),
    val expansionProgress: MutableState<Int> = mutableStateOf(0),
    val contactPerson: MutableState<ContactPerson?> = mutableStateOf(null),
    var showTicketDetailsDialog: MutableState<Boolean> = mutableStateOf(false),
    var showPersonalTicketDetailsDialog: MutableState<Boolean> = mutableStateOf(false),
    val isSwitchEventTutorialVisible: MutableState<Boolean?> = mutableStateOf(null)*/
) : BaseViewState
