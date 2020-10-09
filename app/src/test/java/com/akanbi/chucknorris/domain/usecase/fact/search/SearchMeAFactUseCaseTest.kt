package com.akanbi.chucknorris.domain.usecase.fact.search

import com.akanbi.chucknorris.data.repository.ChuckNorrisRepository
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

    private fun createFactList(): List<Fact> {
        return arrayListOf(
            Fact(factDescription = "Joke 1", icon = "icon 1"),
            Fact(factDescription = "Joke 2", icon = "icon 2"),
            Fact(factDescription = "Joke 3", icon = "icon 3"),
            Fact(factDescription = "Joke 4", icon = "icon 4"),
            Fact(factDescription = "Joke 5", icon = "icon 5")
        )
    }

}