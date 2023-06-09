package com.ashehata.bosta_task.modules.profile.data.model

import androidx.annotation.Keep
import com.squareup.moshi.Json


@Keep
data class GeoDataModel(
    @Json(name = "lat")
    val lat: String? = null,
    @Json(name = "lng")
    val lng: String? = null
)