package com.akanbi.chucknorris.domain.converter

import com.akanbi.chucknorris.data.model.FactListResponse
import com.akanbi.chucknorris.data.model.FactResponse
import com.akanbi.chucknorris.domain.model.Fact

class ListFactConverter : Converter<FactListResponse, List<Fact>> {

    override fun convert(toConvert: FactListResponse): List<Fact> = buildListFacts(toConvert.result)

    private fun buildListFacts(factsResponseList: List<FactResponse>): List<Fact> {
        val factsResult = arrayListOf<Fact>()
        factsResponseList.forEach {
            factsResult.add(buildFact(it))
        }
        return factsResult
    }

}