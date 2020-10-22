package com.akanbi.chucknorris.domain.usecase.fact.random

import com.akanbi.chucknorris.data.repository.ChuckNorrisRepository
import com.akanbi.chucknorris.domain.exception.FactEmptyException
import com.akanbi.chucknorris.domain.model.Fact
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations.init
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.rules.ExpectedException

@ExtendWith(MockKExtension::class)
@DisplayName("Given TellMeAFactRandomUseCase")
internal class TellMeAFactRandomUseCaseTest {
    @InjectMockKs
    private lateinit var useCase: TellMeAFactRandomUseCase
    @MockK
    private lateinit var repository: ChuckNorrisRepository
    private lateinit var factResult: Fact

    @Before
    fun setUp() {
        init(this)
    }

    @Nested
    @DisplayName("When execute TellMeAFactRandomUseCase")
    inner class ExecuteUseCase {

        @Test
        fun `Should return fact random with fields filled`() = runBlocking {
            coEvery { repository.tellMeAFact() } returns ( Fact(factDescription = "Fact", icon = "icon") )
            factResult = useCase.execute()

            assertNotNull(factResult)
            assertEquals("Fact", factResult.factDescription)
            assertEquals("icon", factResult.icon)
        }

        @Test
        fun `should throw FactEmptyException when return fact with factDescription empty`() = runBlocking {
            coEvery { repository.tellMeAFact() } returns ( Fact(factDescription = "", icon = "icon") )
            val exceptionResult = runCatching {
                useCase.execute()
            }.onFailure {
                assertThat(it).isInstanceOf(FactEmptyException::class.java)
            }
            assertThat(exceptionResult.isFailure).isTrue()
        }

    }
}
