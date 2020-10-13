package com.akanbi.chucknorris.data.repository

import com.akanbi.chucknorris.data.api.ChuckNorrisAPI
import com.akanbi.chucknorris.data.model.FactListResponse
import com.akanbi.chucknorris.data.model.FactResponse
import com.akanbi.chucknorris.domain.model.Fact
import io.mockk.MockKAnnotations.init
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
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
    private lateinit var factResult: Fact
    private lateinit var factsResult: List<Fact>

    @Before
    fun setUp() {
        init(this)
    }

    @Nested
    @DisplayName("When request for repository")
    inner class RequestChuckNorrisRepository {

        @Test
        fun `Should fact should not null and fill description and icon fields`() = runBlocking {
            coEvery { api.tellMeAFact().await() } returns ( FactResponse(fact = "Chuck norris fact", iconUrl = "icon", id = "100", url = "url") )
            factResult = repository.tellMeAFact()

            assertNotNull(factResult)
            assertEquals("Chuck norris fact", factResult.factDescription)
            assertEquals("icon", factResult.icon)
        }

        @Test
        fun `Should return list should not null and contains five elements`() = runBlocking {
            coEvery { api.searchMeAFactWith("film").await() } returns ( createFactListResponse() )
            factsResult = repository.searchMeAFactWith("film")

            assertNotNull(factsResult)
            assertEquals(5, factsResult.size)
            assertEquals("Fact 1", factsResult[0].factDescription)
            assertEquals("Fact 2", factsResult[1].factDescription)
            assertEquals("Fact 3", factsResult[2].factDescription)
            assertEquals("Fact 4", factsResult[3].factDescription)
            assertEquals("Fact 5", factsResult[4].factDescription)
        }

        private fun createFactListResponse(): FactListResponse {
            return FactListResponse(arrayListOf(
                FactResponse(fact = "Fact 1", id = "1", iconUrl = "icon 1", url = "url 1"),
                FactResponse(fact = "Fact 2", id = "2", iconUrl = "icon 2", url = "url 2"),
                FactResponse(fact = "Fact 3", id = "3", iconUrl = "icon 3", url = "url 3"),
                FactResponse(fact = "Fact 4", id = "4", iconUrl = "icon 4", url = "url 4"),
                FactResponse(fact = "Fact 5", id = "5", iconUrl = "icon 5", url = "url 5")
            ))
        }
    }

}