package com.akanbi.chucknorris.data.repository

import com.akanbi.chucknorris.data.api.ChuckNorrisAPI
import com.akanbi.chucknorris.data.model.FactResponse
import com.akanbi.chucknorris.domain.model.Fact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ChuckNorrisRepositoryImpl(private val api: ChuckNorrisAPI) : ChuckNorrisRepository {

    override suspend fun tellMeAFact(): Fact {
        return withContext(Dispatchers.IO) {
            val response = api.tellMeAFact().await()
            return@withContext Fact(factDescription = response.fact, icon = response.iconUrl)
        }
    }

    override suspend fun searchMeAFactWith(query: String): List<Fact> {
        return withContext(Dispatchers.IO) {
            val response = api.searchMeAFactWith(query).await()
            return@withContext buildListFacts(response.result)
        }
    }

    private fun buildListFacts(factsResponseList: List<FactResponse>): List<Fact> {
        val factsResult = arrayListOf<Fact>()
        factsResponseList.forEach {
            factsResult.add(buildFact(it))
        }
        return factsResult
    }

    private fun buildFact(factResponse: FactResponse): Fact {
        return Fact(factDescription = factResponse.fact, icon = factResponse.iconUrl)
    }


}