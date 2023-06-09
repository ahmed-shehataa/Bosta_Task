package com.ashehata.bosta_task.modules.profile.presentation.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.ashehata.bosta_task.common.presentation.GeneralObservers
import com.ashehata.bosta_task.modules.destinations.AlbumDetailsScreenDestination
import com.ashehata.bosta_task.modules.profile.presentation.contract.ProfileEvent
import com.ashehata.bosta_task.modules.profile.presentation.contract.ProfileState
import com.ashehata.bosta_task.modules.profile.presentation.contract.ProfileViewState
import com.ashehata.bosta_task.modules.profile.presentation.viewModel.ProfileViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Composable
@Destination(start = true)
fun ProfileScreen(
    navigator: DestinationsNavigator,
    viewModel: ProfileViewModel = hiltViewModel()
) {

    val viewStates = remember {
        viewModel.viewStates ?: ProfileViewState()
    }

    val user = remember {
        viewStates.user
    }

    val albums = remember {
        viewStates.albums
    }

    val onAlbumClicked: (Int) -> Unit = remember {
        {
            viewModel.setEvent(ProfileEvent.OpenAlbumDetailsScreen(it))
        }
    }

    ProfileScreenContent(
        user = user.value,
        albums = albums,
        onAlbumClicked = onAlbumClicked
    )

    GeneralObservers<ProfileState, ProfileViewModel>(viewModel = viewModel) {
        when (it) {
            is ProfileState.OpenAlbumDetailsScreen -> {
                navigator.navigate(AlbumDetailsScreenDestination)
            }
        }
    }

}