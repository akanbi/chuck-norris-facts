package com.akanbi.chucknorris.domain.usecase.fact.search

import com.akanbi.chucknorris.domain.bondary.IChuckNorrisRepository
import com.akanbi.chucknorris.domain.converter.ListFactConverter
import com.akanbi.chucknorris.domain.model.Fact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SearchMeAFactUseCase(private val repository: IChuckNorrisRepository) {
    private val converter = ListFactConverter()

    suspend fun execute(query: String): com.akanbi.commonkotlin.ResultState<List<Fact>> {
        return withContext(Dispatchers.IO) {
            return@withContext com.akanbi.commonkotlin.ResultState.Success(converter.convert(repository.searchMeAFactWith(query)))
        }
    }

}