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

    private var searchFactsViewModel: SearchFactsViewModel = mockk(relaxed = true)
    private var searchMeAFactUseCase: SearchMeAFactUseCase = mockk()

    @Nested
    @DisplayName("When execute search on SearchFactsViewModel")
    inner class SearchFacts {

        @Test
        fun `Should load facts and populate liveData`() = runBlockingTest {
            Dispatchers.setMain(testDispatcher)
            coEvery { searchMeAFactUseCase.execute("android") } returns (createFactList())
            searchFactsViewModel.search("android")

            assertNotNull(searchFactsViewModel.factsListLiveData.value)
        }

        private fun createFactList(): List<Fact> {
            return arrayListOf(
                Fact(factDescription = "Android is very cool", icon = "icon 1"),
                Fact(factDescription = "Android is cool", icon = "icon 2"),
                Fact(factDescription = "Android is regular", icon = "icon 3"),
                Fact(factDescription = "Android is boring", icon = "icon 4"),
                Fact(factDescription = "Android is very boring", icon = "icon 5")
            )
        }

    }

}