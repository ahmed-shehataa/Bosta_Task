package com.ashehata.bosta_task.modules.profile.data.model

import androidx.annotation.Keep
import com.squareup.moshi.Json


@Keep
data class UserDataModel(
    @Json(name = "address")
    val addressDataModel: AddressDataModel? = null,
    @Json(name = "company")
    val companyDataModel: CompanyDataModel? = null,
    @Json(name = "email")
    val email: String? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "phone")
    val phone: String? = null,
    @Json(name = "username")
    val username: String? = null,
    @Json(name = "website")
    val website: String? = null
)
