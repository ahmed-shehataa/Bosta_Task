package com.ashehata.bosta_task.modules.profile.data.mapper

import com.ashehata.bosta_task.modules.profile.data.model.AlbumDataModel
import com.ashehata.bosta_task.modules.profile.domain.model.AlbumDomainModel

fun AlbumDataModel.toDomainModel() = AlbumDomainModel(
    userId = userId, id = id, title = title
)