package com.ashehata.bosta_task.modules.image_viewer.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.ashehata.bosta_task.common.presentation.compose.AppBarWithActions
import com.ashehata.bosta_task.common.presentation.compose.ZoomableImage
import com.ashehata.bosta_task.common.presentation.extensions.shareImage
import com.ashehata.bosta_task.modules.image_viewer.args.ImageViewerScreenNavArgs
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Composable
@Destination(navArgsDelegate = ImageViewerScreenNavArgs::class)
fun ImageViewerScreen(
    navigator: DestinationsNavigator,
    args: ImageViewerScreenNavArgs
) {

    val context = LocalContext.current

    Box {

        ZoomableImage(args.url)

        AppBarWithActions(
            modifier = Modifier.align(Alignment.TopCenter),
            onBackPressed = {
                navigator.popBackStack()
            },
            onSharePressed = {
                context.shareImage(args.url)
            }
        )
    }

}