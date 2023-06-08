package com.ashehata.bosta_task.modules.profile.data.retrofit.response

import androidx.annotation.Keep
import com.ashehata.bosta_task.modules.profile.data.model.AlbumDataModel
import com.squareup.moshi.Json

@Keep
class AlbumsListResponse(
    @Json(name = "major_events")
    val events: List<AlbumDataModel>?
)