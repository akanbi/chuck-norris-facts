package com.akanbi.chucknorris.domain.usecase.fact.random

import com.akanbi.chucknorris.domain.bondary.IChuckNorrisRepository
import com.akanbi.chucknorris.domain.exception.FactEmptyException
import com.akanbi.chucknorris.domain.model.Fact
import com.akanbi.chucknorris.domain.model.response.FactResponse
import io.mockk.MockKAnnotations.init
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
@DisplayName("Given TellMeAFactRandomUseCase")
internal class TellMeAFactRandomUseCaseTest {
    @InjectMockKs
    private lateinit var useCase: TellMeAFactRandomUseCase
    @MockK
    private lateinit var repository: IChuckNorrisRepository
    private lateinit var factResult: com.akanbi.commonkotlin.ResultState<Fact>

    @Before
    fun setUp() {
        init(this)
    }

    @Nested
    @DisplayName("When execute TellMeAFactRandomUseCase")
    inner class ExecuteUseCase {

        @Test
        fun `Should return fact random with fields filled`() = runBlocking {
            coEvery { repository.tellMeAFact() } returns (FactResponse(id = "10", fact = "Fact", iconUrl = "icon", url = "url"))
            factResult = useCase.execute()

            assertNotNull(factResult)
            assertEquals("Fact", (factResult as com.akanbi.commonkotlin.ResultState.Success).data.factDescription)
            assertEquals("icon", (factResult as com.akanbi.commonkotlin.ResultState.Success).data.icon)
        }

        @Test
        fun `should return FactEmptyException when return fact with factDescription empty`() = runBlocking {
            coEvery { repository.tellMeAFact() } returns (FactResponse(
                id = "20",
                fact = "",
                iconUrl = "icon",
                url = "url"
            ))
            val exceptionResult = useCase.execute()

            assertTrue((exceptionResult as com.akanbi.commonkotlin.ResultState.Error).exception is FactEmptyException)
            assertEquals("Fact is empty!", exceptionResult.exception.message)
        }
    }
}
