package com.ashehata.bosta_task.modules.profile.data.retrofit.response

import androidx.annotation.Keep
import com.ashehata.bosta_task.modules.profile.data.model.UserDataModel
import com.squareup.moshi.Json

@Keep
class UsersListResponse(
    @Json(name = "major_events")
    val users: List<UserDataModel>?
)