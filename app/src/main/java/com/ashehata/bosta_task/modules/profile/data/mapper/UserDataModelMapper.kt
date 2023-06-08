package com.ashehata.bosta_task.modules.profile.data.mapper

import com.ashehata.bosta_task.modules.profile.data.model.UserDataModel
import com.ashehata.bosta_task.modules.profile.domain.model.UserDomainModel

fun UserDataModel.toDomainModel() = UserDomainModel(
    id = id ?: -1,
    name = name,
    address = addressDataModel?.let {
        it.street.plus(" ")
            .plus(it.suite).plus(" ")
            .plus(it.city).plus(" ".plus(it.zipcode))
    }
)