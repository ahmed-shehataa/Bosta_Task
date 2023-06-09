package com.ashehata.bosta_task.modules.profile.presentation.mapper

import com.ashehata.bosta_task.modules.profile.domain.model.UserDomainModel
import com.ashehata.bosta_task.modules.profile.presentation.model.UserUIModel

fun UserDomainModel.toUIModel() = UserUIModel(
    id = id,
    name = name,
    address = address
)