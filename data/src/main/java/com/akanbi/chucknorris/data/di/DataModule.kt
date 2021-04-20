package com.akanbi.chucknorris.data.di

import com.akanbi.chucknorris.data.BuildConfig.NORRIS_API_URL
import com.akanbi.chucknorris.data.api.ChuckNorrisAPI
import com.akanbi.chucknorris.data.repository.ChuckNorrisRepositoryImpl
import com.akanbi.chucknorris.domain.bondary.IChuckNorrisRepository
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val dataModule = module {
    single {
        buildRetrofit()
    }

    single<ChuckNorrisAPI> {
        get<Retrofit>().create(ChuckNorrisAPI::class.java)
    }

    single<IChuckNorrisRepository> {
        ChuckNorrisRepositoryImpl(get<ChuckNorrisAPI>())
    }
}

private fun buildRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(NORRIS_API_URL)
        .client(OkHttpClient.Builder().build())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
        .build()
}