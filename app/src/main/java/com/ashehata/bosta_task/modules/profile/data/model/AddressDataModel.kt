package com.ashehata.bosta_task.modules.profile.data.model

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class AddressDataModel(
    @Json(name = "city")
    val city: String? = null,
    @Json(name = "geo")
    val geoDataModel: GeoDataModel? = null,
    @Json(name = "street")
    val street: String? = null,
    @Json(name = "suite")
    val suite: String? = null,
    @Json(name = "zipcode")
    val zipcode: String? = null
)