package com.akanbi.chucknorris.domain.di

import com.akanbi.chucknorris.domain.bondary.IChuckNorrisRepository
import com.akanbi.chucknorris.domain.usecase.fact.random.TellMeAFactRandomUseCase
import com.akanbi.chucknorris.domain.usecase.fact.search.SearchMeAFactUseCase
import org.koin.dsl.module

val domainModule = module {

    single {
        TellMeAFactRandomUseCase(get<IChuckNorrisRepository>())
    }

    single {
        SearchMeAFactUseCase(get<IChuckNorrisRepository>())
    }

}