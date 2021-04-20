package com.akanbi.chucknorris.domain.model.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FactListResponse(
    val result: List<FactResponse>
) {
}