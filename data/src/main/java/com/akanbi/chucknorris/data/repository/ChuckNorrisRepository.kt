package com.akanbi.chucknorris.data.repository

import com.akanbi.chucknorris.data.model.FactListResponse
import com.akanbi.chucknorris.data.model.FactResponse

/**
 * Interface que é a fronteira entre a camada de Data com a Domain
 */
interface ChuckNorrisRepository {

    suspend fun tellMeAFact(): FactResponse

    suspend fun searchMeAFactWith(query: String): FactListResponse

}