package com.akanbi.chucknorris.data.repository

import com.akanbi.chucknorris.data.api.ChuckNorrisAPI
import com.akanbi.chucknorris.data.model.FactListResponse
import com.akanbi.chucknorris.data.model.FactResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ChuckNorrisRepositoryImpl(private val api: ChuckNorrisAPI) : ChuckNorrisRepository {

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