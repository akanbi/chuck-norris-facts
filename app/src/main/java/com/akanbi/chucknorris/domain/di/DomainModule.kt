package com.akanbi.chucknorris.domain.di

import com.akanbi.chucknorris.data.repository.ChuckNorrisRepository
import com.akanbi.chucknorris.domain.usecase.fact.random.TellMeAFactRandomUseCase
import org.koin.dsl.module

val domainModule = module {

    single<TellMeAFactRandomUseCase> {
        TellMeAFactRandomUseCase(get<ChuckNorrisRepository>())
    }

}