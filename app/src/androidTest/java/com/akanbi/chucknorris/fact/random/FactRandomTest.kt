package com.akanbi.chucknorris.fact.random

import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.akanbi.chucknorris.presentation.view.ChuckNorrisFactsActivity
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class FactRandomTest {

    @get:Rule
    val chuckNorrisRule = ActivityTestRule(ChuckNorrisFactsActivity::class.java)

    private lateinit var chuckNorrisActivity: ChuckNorrisFactsActivity

    @Before
    fun setUp() {
        chuckNorrisActivity = chuckNorrisRule.activity
    }

    @Test
    fun shouldVerifyContentOfFact() {
        fact {
        } verify {
            sleep(2000)
            containsFactContent()
        }
    }

    @Test
    fun shouldReloadFactAndVerifyIfHasContent() {
        fact {
            sleep(2000)
            containsFactContent()
            loadNewFact()
        } verify {
            sleep(2000)
            containsFactContent()
        }
    }


}