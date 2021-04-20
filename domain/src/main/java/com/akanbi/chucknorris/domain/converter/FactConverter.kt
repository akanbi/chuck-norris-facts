package com.akanbi.chucknorris.domain.converter

import com.akanbi.chucknorris.domain.model.response.FactResponse
import com.akanbi.chucknorris.domain.model.Fact

class FactConverter : Converter<FactResponse, Fact> {

    override fun convert(toConvert: FactResponse) = buildFact(toConvert)
}