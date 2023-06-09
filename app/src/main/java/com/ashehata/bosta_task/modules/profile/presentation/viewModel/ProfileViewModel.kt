package com.ashehata.bosta_task.modules.profile.presentation.viewModel

import com.ashehata.bosta_task.base.BaseViewModel
import com.ashehata.bosta_task.modules.profile.domain.usecase.GetAlbumsUseCase
import com.ashehata.bosta_task.modules.profile.domain.usecase.GetUsersUseCase
import com.ashehata.bosta_task.modules.profile.presentation.contract.ProfileEvent
import com.ashehata.bosta_task.modules.profile.presentation.contract.ProfileState
import com.ashehata.bosta_task.modules.profile.presentation.contract.ProfileViewState
import com.ashehata.bosta_task.modules.profile.presentation.mapper.toUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
    private val getAlbumsUseCase: GetAlbumsUseCase,
) : BaseViewModel<ProfileEvent, ProfileViewState, ProfileState>() {

    private val userExceptionHandler = exceptionHandler {
        viewStates?.let {
            it.isLoading.value = false
            it.isNetworkError.value = true
            it.user.value = null
            it.albums.clear()
        }
    }

    init {
        getUserData()
    }

    override fun handleEvents(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.OpenAlbumDetailsScreen -> setState {
                ProfileState.OpenAlbumDetailsScreen(
                    id = event.albumUIModel.id ?: -1,
                    albumName = event.albumUIModel.title ?: ""
                )
            }
            ProfileEvent.RefreshScreen -> {
                getUserData()
            }
        }
    }

    private fun getUserData() {
        launchCoroutine(userExceptionHandler) {
            viewStates?.let {
                setLoading()
                it.user.value = getUsersUseCase.execute().random().toUIModel()

                val albumsList = getAlbumsUseCase.execute(
                    viewStates?.user?.value?.id ?: -1
                ).map { it.toUIModel() }

                it.albums.clear()
                it.albums.addAll(albumsList)
                setDoneLoading()
            }
        }
    }

    override fun createInitialViewState(): ProfileViewState {
        return ProfileViewState()
    }
}