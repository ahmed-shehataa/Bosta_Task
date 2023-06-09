package com.ashehata.bosta_task.modules.profile.presentation.mapper

import com.ashehata.bosta_task.modules.profile.domain.model.AlbumDomainModel
import com.ashehata.bosta_task.modules.profile.presentation.model.AlbumUIModel

fun AlbumDomainModel.toUIModel() = AlbumUIModel(
    userId = userId, id = id, title = title
)