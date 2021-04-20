package com.akanbi.chucknorris.domain.usecase.fact.random

import com.akanbi.chucknorris.domain.bondary.IChuckNorrisRepository
import com.akanbi.chucknorris.domain.converter.FactConverter
import com.akanbi.chucknorris.domain.exception.FactEmptyException
import com.akanbi.chucknorris.domain.model.Fact
import com.akanbi.commonkotlin.ResultState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TellMeAFactRandomUseCase(private val repository: IChuckNorrisRepository) {
    private val converter = FactConverter()

    suspend fun execute(): ResultState<Fact> {
        return withContext(Dispatchers.IO) {
            val fact = converter.convert(repository.tellMeAFact())
            if (verifyFieldsHasFill(fact))
                return@withContext ResultState.Success(fact)

            return@withContext ResultState.Error(FactEmptyException("Fact is empty!"))
        }
    }

    private fun verifyFieldsHasFill(fact: Fact) = fact.factDescription.isNotBlank() && fact.icon.isNotBlank()

}