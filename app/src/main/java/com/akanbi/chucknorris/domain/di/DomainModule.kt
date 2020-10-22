package com.akanbi.chucknorris.domain.di

import com.akanbi.chucknorris.data.repository.ChuckNorrisRepository
import com.akanbi.chucknorris.domain.usecase.fact.random.TellMeAFactRandomUseCase
import com.akanbi.chucknorris.domain.usecase.fact.search.SearchMeAFactUseCase
import org.koin.dsl.module

val domainModule = module {

    single {
        TellMeAFactRandomUseCase(get<ChuckNorrisRepository>())
    }

    single {
        SearchMeAFactUseCase(get<ChuckNorrisRepository>())
    }

}