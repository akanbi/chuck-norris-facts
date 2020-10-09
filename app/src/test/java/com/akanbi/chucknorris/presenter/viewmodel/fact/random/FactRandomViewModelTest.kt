package com.akanbi.chucknorris.presenter.viewmodel.fact.random

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.akanbi.chucknorris.domain.model.Fact
import com.akanbi.chucknorris.domain.usecase.fact.random.TellMeAFactRandomUseCase
import io.mockk.coEvery
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Rule
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExperimentalCoroutinesApi
@ExtendWith(MockKExtension::class)
@DisplayName("Given FactRandomViewModel")
internal class FactRandomViewModelTest {
    @JvmField
    @Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val testDispatcher = TestCoroutineDispatcher()

    private var factRandomViewModel: FactRandomViewModel = mockk(relaxed = true)
    private var tellMeAFactRandomUseCase: TellMeAFactRandomUseCase = mockk()

    @Nested
    @DisplayName("When execute load on FactRandomViewModel")
    inner class LoadFactRandom {

        @Test
        fun `Should load one fact and populate liveData`() = runBlockingTest {
            Dispatchers.setMain(testDispatcher)
            coEvery { tellMeAFactRandomUseCase.execute() } returns (Fact("Fact loaded", icon = "icon"))
            factRandomViewModel.loadFactRandom()

            assertNotNull(factRandomViewModel.factLiveData.value)
        }

    }
}