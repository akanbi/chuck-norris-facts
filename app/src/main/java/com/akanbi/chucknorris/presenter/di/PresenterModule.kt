package com.akanbi.chucknorris.presenter.di

import com.akanbi.chucknorris.domain.usecase.fact.random.TellMeAFactRandomUseCase
import com.akanbi.chucknorris.presenter.viewmodel.fact.random.FactRandomViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presenterModule = module {

    viewModel {
        FactRandomViewModel(get<TellMeAFactRandomUseCase>())
    }

}