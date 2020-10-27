package com.akanbi.chucknorris.domain.converter

import com.akanbi.chucknorris.data.model.FactResponse
import com.akanbi.chucknorris.domain.model.Fact

class FactConverter : Converter<FactResponse, Fact> {

    override fun convert(toConvert: FactResponse): Fact = buildFact(toConvert)
}