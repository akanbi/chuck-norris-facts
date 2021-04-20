package com.akanbi.chucknorris.data.repository

import com.akanbi.chucknorris.data.api.ChuckNorrisAPI
import com.akanbi.chucknorris.domain.bondary.IChuckNorrisRepository
import com.akanbi.chucknorris.domain.model.response.FactListResponse
import com.akanbi.chucknorris.domain.model.response.FactResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ChuckNorrisRepositoryImpl(private val api: ChuckNorrisAPI) : IChuckNorrisRepository {

    override suspend fun tellMeAFact(): FactResponse {
        return withContext(Dispatchers.IO) {
            return@withContext api.tellMeAFact().await()
        }
    }

    override suspend fun searchMeAFactWith(query: String): FactListResponse {
        return withContext(Dispatchers.IO) {
            return@withContext api.searchMeAFactWith(query).await()
        }
    }

}