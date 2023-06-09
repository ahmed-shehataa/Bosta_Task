package com.ashehata.bosta_task.modules.album_details.data.mapper

import com.ashehata.bosta_task.modules.album_details.data.model.PhotoDataModel
import com.ashehata.bosta_task.modules.album_details.domain.model.PhotoDomainModel

fun PhotoDataModel.toDomainModel() = PhotoDomainModel(
    albumId, id, thumbnailUrl, title, url
)