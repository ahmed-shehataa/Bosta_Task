package com.ashehata.bosta_task.modules.profile.data.model

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class CompanyDataModel(
    @Json(name = "bs")
    val bs: String? = null,
    @Json(name = "catchPhrase")
    val catchPhrase: String? = null,
    @Json(name = "name")
    val name: String? = null
)