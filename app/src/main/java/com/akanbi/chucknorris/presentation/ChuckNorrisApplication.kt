package com.akanbi.chucknorris.presentation

import android.app.Application
import com.akanbi.chucknorris.data.di.dataModule
import com.akanbi.chucknorris.domain.di.domainModule
import com.akanbi.chucknorris.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ChuckNorrisApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ChuckNorrisApplication)
            modules(arrayListOf(dataModule, domainModule, presentationModule))
        }
    }

}