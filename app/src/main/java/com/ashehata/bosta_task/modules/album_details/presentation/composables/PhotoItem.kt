package com.ashehata.bosta_task.modules.album_details.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ashehata.bosta_task.modules.album_details.presentation.model.PhotoUIModel

@Composable
fun PhotoItem(photo: PhotoUIModel?, onPhotoClicked: (String?) -> Unit) {

    Box(
        modifier = Modifier.clickable {
            onPhotoClicked(photo?.url)
        }
    ) {
        val showTitle = remember {
            mutableStateOf(false)
        }

        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(photo?.thumbnailUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            onSuccess = {
                showTitle.value = true
            }
        )

        if (showTitle.value)
            Text(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(start = 4.dp, end = 4.dp, bottom = 4.dp),
                text = photo?.title ?: "",
                style = MaterialTheme.typography.body1.copy(
                    color = MaterialTheme.colors.onSecondary
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
    }
}