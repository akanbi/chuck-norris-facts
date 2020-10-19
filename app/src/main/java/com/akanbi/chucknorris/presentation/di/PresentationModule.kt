package com.akanbi.chucknorris.presentation.di

import com.akanbi.chucknorris.domain.usecase.fact.random.TellMeAFactRandomUseCase
import com.akanbi.chucknorris.presentation.fact.random.FactRandomViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel<FactRandomViewModel> {
        FactRandomViewModel(get<TellMeAFactRandomUseCase>())
    }

}