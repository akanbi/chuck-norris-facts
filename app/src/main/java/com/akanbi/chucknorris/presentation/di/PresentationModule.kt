package com.akanbi.chucknorris.presentation.di

import com.akanbi.chucknorris.domain.usecase.fact.random.TellMeAFactRandomUseCase
import com.akanbi.chucknorris.domain.usecase.fact.search.SearchMeAFactUseCase
import com.akanbi.chucknorris.presentation.fact.random.FactRandomViewModel
import com.akanbi.chucknorris.presentation.fact.search.SearchFactsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel {
        FactRandomViewModel(get<com.akanbi.chucknorris.domain.usecase.fact.random.TellMeAFactRandomUseCase>())
    }

    viewModel {
        SearchFactsViewModel(get<com.akanbi.chucknorris.domain.usecase.fact.search.SearchMeAFactUseCase>())
    }

}