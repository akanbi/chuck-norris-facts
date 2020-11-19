package com.akanbi.chucknorris.fact.search

import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.akanbi.chucknorris.presentation.view.ChuckNorrisFactsActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class SearchFactTest {
    @get:Rule
    val chuckNorrisRule = ActivityTestRule(ChuckNorrisFactsActivity::class.java)

    private lateinit var chuckNorrisActivity: ChuckNorrisFactsActivity

    @Before
    fun setUp() {
        chuckNorrisActivity = chuckNorrisRule.activity
    }

    @Test
    fun shouldSearchAndVerifyIfHasContent() {
        search {
            clickSearch()
            typeContentBySearch("the rock")
            pressEnter()
            sleep(3000)
        } verify {
            checkContentBy("Search by: the rock")
        }
    }
}