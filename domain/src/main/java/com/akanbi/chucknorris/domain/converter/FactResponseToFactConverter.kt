package com.akanbi.chucknorris.domain.converter

import com.akanbi.chucknorris.data.model.FactResponse
import com.akanbi.chucknorris.domain.model.Fact

class FactResponseToFactConverter {

    fun convert(response: FactResponse): Fact = buildFact(response)
}