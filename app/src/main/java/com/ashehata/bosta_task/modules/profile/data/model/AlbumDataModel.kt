package com.ashehata.bosta_task.modules.profile.data.model

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class AlbumDataModel(
    @Json(name = "userId")
    val userId: Int? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "title")
    val title: String? = null,
)