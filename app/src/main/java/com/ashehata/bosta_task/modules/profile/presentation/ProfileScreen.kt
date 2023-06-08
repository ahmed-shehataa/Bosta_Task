package com.ashehata.bosta_task.modules.profile.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.ashehata.bosta_task.R
import com.ashehata.bosta_task.common.presentation.AppBar
import com.ramcosta.composedestinations.annotation.Destination
import dagger.hilt.android.lifecycle.HiltViewModel


@Composable
@Destination(start = true)
fun ProfileScreen(
    profileViewModel: ProfileViewModel = hiltViewModel()
) {

    Column {

        AppBar(
            title = stringResource(id = R.string.profile),
            extraBody = {
                Text(
                    text = "Ahmed Hamdy",
                    style = MaterialTheme.typography.body1.copy(
                        color = MaterialTheme.colors.onSecondary
                    )
                )
                Text(
                    text = "76 EL Madeena Al Monawara St., Al Dakahlia",
                    style = MaterialTheme.typography.body1.copy(
                        color = MaterialTheme.colors.onSecondary
                    )
                )
            }
        )



    }
}