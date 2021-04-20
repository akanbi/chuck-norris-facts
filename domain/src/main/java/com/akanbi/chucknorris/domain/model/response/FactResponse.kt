package com.akanbi.chucknorris.domain.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FactResponse(
    val id: String,
    @Json(name = "icon_url") val iconUrl: String,
    val url: String,
    @Json(name = "value") val fact: String
) {
}
