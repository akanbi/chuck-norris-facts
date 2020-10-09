package com.akanbi.chucknorris.data.api

import com.akanbi.chucknorris.data.model.FactListResponse
import com.akanbi.chucknorris.data.model.FactResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisAPI {

    @GET("random")
    fun tellMeAFact() : Deferred<FactResponse>

    @GET("search")
    fun searchMeAFactWith(@Query("query") query: String) : Deferred<FactListResponse>
}