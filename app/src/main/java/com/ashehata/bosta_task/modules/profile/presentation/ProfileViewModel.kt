package com.ashehata.bosta_task.modules.profile.presentation

import com.ashehata.bosta_task.base.BaseViewModel
import com.ashehata.bosta_task.modules.profile.domain.usecase.GetUsersUseCase
import com.ashehata.bosta_task.modules.profile.presentation.contract.ProfileEvent
import com.ashehata.bosta_task.modules.profile.presentation.contract.ProfileState
import com.ashehata.bosta_task.modules.profile.presentation.contract.ProfileViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
) : BaseViewModel<ProfileEvent, ProfileViewState, ProfileState>() {

    init {
        launchCoroutine {
            getUsersUseCase.execute()
        }
    }

    override fun handleEvents(event: ProfileEvent) {

    }

    override fun createInitialViewState(): ProfileViewState {
        return ProfileViewState()
    }
}