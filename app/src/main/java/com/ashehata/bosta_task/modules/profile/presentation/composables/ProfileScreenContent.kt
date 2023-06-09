package com.ashehata.bosta_task.modules.profile.presentation.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ashehata.bosta_task.R
import com.ashehata.bosta_task.common.presentation.compose.AppBar
import com.ashehata.bosta_task.common.presentation.compose.HeaderShadow
import com.ashehata.bosta_task.common.presentation.compose.LoadingView
import com.ashehata.bosta_task.common.presentation.compose.NetworkErrorView
import com.ashehata.bosta_task.modules.profile.presentation.model.AlbumUIModel
import com.ashehata.bosta_task.modules.profile.presentation.model.UserUIModel


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfileScreenContent(
    user: UserUIModel?,
    albums: List<AlbumUIModel?>,
    onAlbumClicked: (AlbumUIModel) -> Unit,
    isLoading: Boolean,
    isNetworkError: Boolean,
    onRefresh: () -> Unit,
    isRefreshing: Boolean
) {

    val state = rememberPullRefreshState(isRefreshing, onRefresh)

    Box(Modifier.pullRefresh(state)) {
        Column {

            HeaderShadow {
                AppBar(
                    Modifier.padding(
                        top = 12.dp,
                        end = 20.dp,
                        start = 20.dp
                    ),
                    title = stringResource(id = R.string.profile),
                    extraBody = {

                        user?.name?.let {
                            Text(
                                text = it,
                                style = MaterialTheme.typography.body1.copy(
                                    color = MaterialTheme.colors.onSecondary
                                )
                            )
                        }

                        user?.address?.let {
                            Text(
                                text = it,
                                style = MaterialTheme.typography.body1.copy(
                                    color = MaterialTheme.colors.onSecondary
                                )
                            )
                        }


                    },
                )
            }



            if (isNetworkError) {
                NetworkErrorView(onRefresh)

            } else if (isLoading) {
                LoadingView()

            } else {

                LazyColumn {
                    itemsIndexed(albums) { index, album ->
                        album?.let {
                            AlbumItem(
                                albumModel = album,
                                hasDivider = albums.lastIndex != index,
                                onAlbumClicked = onAlbumClicked
                            )
                        }
                    }
                }
            }
        }

        PullRefreshIndicator(isRefreshing, state, Modifier.align(Alignment.TopCenter))

    }
}