package com.akanbi.chucknorris.presentation.fact.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.akanbi.chucknorris.domain.model.Fact
import com.akanbi.chucknorris.domain.usecase.fact.random.TellMeAFactRandomUseCase
import com.akanbi.chucknorris.domain.usecase.fact.search.SearchMeAFactUseCase
import com.akanbi.chucknorris.presentation.fact.random.FactRandomViewModel
import io.mockk.coEvery
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Rule
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExperimentalCoroutinesApi
@ExtendWith(MockKExtension::class)
@DisplayName("Given SearchFactsViewModel")
internal class SearchFactsViewModelTest {
    @JvmField
    @Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    private lateinit var searchFactsViewModel: SearchFactsViewModel
    private var searchMeAFactUseCase: SearchMeAFactUseCase = mockk()

    @Nested
    @DisplayName("When execute search on SearchFactsViewModel")
    inner class SearchFacts {

        @Test
        fun `Should load facts and populate liveData`() = testDispatcher.runBlockingTest {
            Dispatchers.setMain(testDispatcher)
            searchFactsViewModel = SearchFactsViewModel(searchMeAFactUseCase, testScope)
            searchFactsViewModel.search("android")

            coEvery { searchMeAFactUseCase.execute("android") }
        }

    }

}