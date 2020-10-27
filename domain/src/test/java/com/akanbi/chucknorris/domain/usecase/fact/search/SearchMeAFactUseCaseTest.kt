package com.akanbi.chucknorris.domain.usecase.fact.search

import com.akanbi.chucknorris.data.model.FactListResponse
import com.akanbi.chucknorris.data.model.FactResponse
import com.akanbi.chucknorris.data.repository.ChuckNorrisRepository
import com.akanbi.chucknorris.domain.model.Fact
import com.akanbi.chucknorris.domain.usecase.fact.search.SearchMeAFactUseCase
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
@DisplayName("Given SearchMeAFactUseCase")
internal class SearchMeAFactUseCaseTest {
    @InjectMockKs
    private lateinit var useCase: SearchMeAFactUseCase
    @MockK
    private lateinit var repository: ChuckNorrisRepository
    private lateinit var listFactsResult: List<Fact>

    @Before
    fun setUp() {
        init(this)
    }

    @DisplayName("When execute SearchMeAFactUseCase")
    @Nested
    inner class ExecuteUseCase {

        @Test
        fun `Should return list with five elements with fields filled`() = runBlocking {
            coEvery { repository.searchMeAFactWith("joke") } returns ( createFactList() )
            listFactsResult = useCase.execute("joke")

            assertNotNull(listFactsResult)
            assertEquals(5, listFactsResult.size)
        }
    }

    private fun createFactList(): FactListResponse {
        return FactListResponse(arrayListOf(
            FactResponse(id = "1", fact = "Joke 1", iconUrl = "icon 1", url = "url 1"),
            FactResponse(id = "2", fact = "Joke 2", iconUrl = "icon 2", url = "url 2"),
            FactResponse(id = "3", fact = "Joke 3", iconUrl = "icon 3", url = "url 3"),
            FactResponse(id = "4", fact = "Joke 4", iconUrl = "icon 4", url = "url 4"),
            FactResponse(id = "5", fact = "Joke 5", iconUrl = "icon 5", url = "url 5")
        ))

    }

}