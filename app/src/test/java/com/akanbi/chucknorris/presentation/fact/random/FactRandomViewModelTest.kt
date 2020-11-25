package com.akanbi.chucknorris.presentation.fact.random

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.akanbi.chucknorris.domain.model.Fact
import com.akanbi.chucknorris.domain.usecase.fact.random.TellMeAFactRandomUseCase
import com.akanbi.chucknorris.presentation.fact.random.FactRandomViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Rule
import org.junit.jupiter.api.Assertions.assertNotNull
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
    private val testScope = TestCoroutineScope(testDispatcher)

    private lateinit var factRandomViewModel: FactRandomViewModel
    private var tellMeAFactRandomUseCase: TellMeAFactRandomUseCase = mockk(relaxed = true)

    @Nested
    @DisplayName("When execute load on FactRandomViewModel")
    inner class LoadFactRandom {

        @Test
        fun `Should verify call use case correct`() = testDispatcher.runBlockingTest {
            Dispatchers.setMain(testDispatcher)
            factRandomViewModel = FactRandomViewModel(tellMeAFactRandomUseCase, testScope)
            factRandomViewModel.loadFactRandom()

            coVerify { tellMeAFactRandomUseCase.execute() }
        }

    }
}