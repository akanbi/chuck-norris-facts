package com.akanbi.chucknorris.domain.bondary

import com.akanbi.chucknorris.domain.model.response.FactListResponse
import com.akanbi.chucknorris.domain.model.response.FactResponse

interface IChuckNorrisRepository {

    suspend fun tellMeAFact(): FactResponse

    suspend fun searchMeAFactWith(query: String): FactListResponse

}