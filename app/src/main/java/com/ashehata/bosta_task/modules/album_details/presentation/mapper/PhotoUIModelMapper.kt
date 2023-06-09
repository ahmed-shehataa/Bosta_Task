package com.ashehata.bosta_task.modules.album_details.presentation.mapper

import com.ashehata.bosta_task.modules.album_details.domain.model.PhotoDomainModel
import com.ashehata.bosta_task.modules.album_details.presentation.model.PhotoUIModel

fun PhotoDomainModel.toUIModel() = PhotoUIModel(
    albumId, id, thumbnailUrl, title, url
)