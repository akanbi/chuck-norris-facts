package com.akanbi.chucknorris

import com.akanbi.chucknorris.data.api.ChuckNorrisAPI
import com.akanbi.chucknorris.data.di.dataModule
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class ChuckNorrisAPIIntegrationTest : KoinTest {

    private val api: ChuckNorrisAPI by inject()

    @Before
    fun setUp() {
        stopKoin()
        startKoin {
            modules(dataModule)
        }
    }

    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun shouldReturnFactResponse() = runBlocking {
        val factResponse = api.tellMeAFact().await()

        assertNotNull(factResponse)
        assertTrue(factResponse.fact.isNotBlank())
    }

    @Test
    fun shouldReturnListWithFactsResponse() = runBlocking {
        val factsResponse = api.searchMeAFactWith("film").await()

        assertNotNull(factsResponse)
        assertTrue(factsResponse.result.size > 1)
    }

}