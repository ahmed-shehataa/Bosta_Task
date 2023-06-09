package com.ashehata.bosta_task.modules.album_details.data.model

import androidx.annotation.Keep
import com.squareup.moshi.Json


@Keep
data class PhotoDataModel(
    @Json(name = "albumId")
    val albumId: Int? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "thumbnailUrl")
    val thumbnailUrl: String? = null,
    @Json(name = "title")
    val title: String? = null,
    @Json(name = "url")
    val url: String? = null
)