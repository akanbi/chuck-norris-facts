package com.akanbi.chucknorris.domain.usecase.fact.search

import com.akanbi.chucknorris.common.ResultState
import com.akanbi.chucknorris.data.repository.ChuckNorrisRepository
import com.akanbi.chucknorris.domain.converter.ListFactConverter
import com.akanbi.chucknorris.domain.model.Fact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SearchMeAFactUseCase(private val repository: ChuckNorrisRepository) {
    private val converter = ListFactConverter()

    suspend fun execute(query: String): ResultState<List<Fact>> {
        return withContext(Dispatchers.IO) {
            return@withContext ResultState.Success(converter.convert(repository.searchMeAFactWith(query)))
        }
    }

}