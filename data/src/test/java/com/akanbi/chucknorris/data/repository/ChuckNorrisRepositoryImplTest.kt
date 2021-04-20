package com.akanbi.chucknorris.data.repository

import com.akanbi.chucknorris.data.api.ChuckNorrisAPI
import com.akanbi.chucknorris.domain.model.response.FactListResponse
import com.akanbi.chucknorris.domain.model.response.FactResponse
import io.mockk.MockKAnnotations.init
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
@DisplayName("Given ChuckNorrisRepository")
internal class ChuckNorrisRepositoryImplTest {
    @InjectMockKs
    private lateinit var repository : ChuckNorrisRepositoryImpl
    @MockK
    private lateinit var api: ChuckNorrisAPI
    private lateinit var factResponseResult: com.akanbi.chucknorris.domain.model.response.FactResponse
    private lateinit var factListResponseResult: com.akanbi.chucknorris.domain.model.response.FactListResponse

    @Before
    fun setUp() {
        init(this)
    }

    @Nested
    @DisplayName("When request for repository")
    inner class RequestChuckNorrisRepository {

        @Test
        fun `Should fact should not null and fill description and icon fields`() = runBlocking {
            coEvery { api.tellMeAFact().await() } returns (com.akanbi.chucknorris.domain.model.response.FactResponse(
                    fact = "Chuck norris fact",
                    iconUrl = "icon",
                    id = "100",
                    url = "url"
            ))
            factResponseResult = repository.tellMeAFact()

            assertNotNull(factResponseResult)
            assertEquals("Chuck norris fact", factResponseResult.fact)
            assertEquals("icon", factResponseResult.iconUrl)
        }

        @Test
        fun `Should return list should not null and contains five elements`() = runBlocking {
            coEvery { api.searchMeAFactWith("film").await() } returns ( createFactListResponse() )
            factListResponseResult = repository.searchMeAFactWith("film")

            assertNotNull(factListResponseResult.result)
            assertEquals(5, factListResponseResult.result.size)
            assertEquals("Fact 1", factListResponseResult.result[0].fact)
            assertEquals("Fact 2", factListResponseResult.result[1].fact)
            assertEquals("Fact 3", factListResponseResult.result[2].fact)
            assertEquals("Fact 4", factListResponseResult.result[3].fact)
            assertEquals("Fact 5", factListResponseResult.result[4].fact)
        }

        private fun createFactListResponse(): com.akanbi.chucknorris.domain.model.response.FactListResponse {
            return com.akanbi.chucknorris.domain.model.response.FactListResponse(
                    arrayListOf(
                            com.akanbi.chucknorris.domain.model.response.FactResponse(
                                    fact = "Fact 1",
                                    id = "1",
                                    iconUrl = "icon 1",
                                    url = "url 1"
                            ),
                            com.akanbi.chucknorris.domain.model.response.FactResponse(
                                    fact = "Fact 2",
                                    id = "2",
                                    iconUrl = "icon 2",
                                    url = "url 2"
                            ),
                            com.akanbi.chucknorris.domain.model.response.FactResponse(
                                    fact = "Fact 3",
                                    id = "3",
                                    iconUrl = "icon 3",
                                    url = "url 3"
                            ),
                            com.akanbi.chucknorris.domain.model.response.FactResponse(
                                    fact = "Fact 4",
                                    id = "4",
                                    iconUrl = "icon 4",
                                    url = "url 4"
                            ),
                            com.akanbi.chucknorris.domain.model.response.FactResponse(
                                    fact = "Fact 5",
                                    id = "5",
                                    iconUrl = "icon 5",
                                    url = "url 5"
                            )
                    )
            )
        }
    }

}