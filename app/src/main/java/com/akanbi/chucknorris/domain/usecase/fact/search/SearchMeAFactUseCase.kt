package com.akanbi.chucknorris.domain.usecase.fact.search

import com.akanbi.chucknorris.data.repository.ChuckNorrisRepository
import com.akanbi.chucknorris.domain.model.Fact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SearchMeAFactUseCase(private val repository: ChuckNorrisRepository) {

    suspend fun execute(query: String): List<Fact> {
        return withContext(Dispatchers.IO) {
            return@withContext repository.searchMeAFactWith(query)
        }
    }

}