package com.akanbi.chucknorris.data.repository

import com.akanbi.chucknorris.domain.model.Fact

/**
 * Interface que é a fronteira entre a camada de Data com a Domain
 */
interface ChuckNorrisRepository {

    suspend fun tellMeAFact(): Fact

    suspend fun searchMeAFactWith(query: String): List<Fact>

}