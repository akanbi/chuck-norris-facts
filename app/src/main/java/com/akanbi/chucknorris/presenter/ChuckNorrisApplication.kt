package com.akanbi.chucknorris.presenter

import android.app.Application
import com.akanbi.chucknorris.data.di.dataModule
import com.akanbi.chucknorris.domain.di.domainModule
import com.akanbi.chucknorris.presenter.di.presenterModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ChuckNorrisApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ChuckNorrisApplication)
            modules(arrayListOf(dataModule, domainModule, presenterModule))
        }
    }

}