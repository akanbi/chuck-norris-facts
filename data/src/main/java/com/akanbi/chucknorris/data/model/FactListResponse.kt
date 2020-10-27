package com.akanbi.chucknorris.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FactListResponse(
    val result: List<FactResponse>
) {
}