package com.akanbi.chucknorris.fact.random

import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.web.assertion.WebViewAssertions.webContent
import androidx.test.espresso.web.matcher.DomMatchers.hasElementWithId
import androidx.test.espresso.web.sugar.Web.onWebView
import com.akanbi.chucknorris.BaseRobot
import com.akanbi.chucknorris.R

fun fact(executeFun: FactRandomRobot.() -> Unit) = FactRandomRobot().apply{ executeFun() }

class FactRandomRobot : BaseRobot() {

    fun loadNewFact() {
        clickButtonBy(R.id.reloadFact)
    }

    fun containsFactContent() {
        onWebView(withId(R.id.factDescription)).forceJavascriptEnabled()
        onWebView(withId(R.id.factDescription)).check(webContent(hasElementWithId("factContent")))
    }

    infix fun verify(executeFun: FactRandomRobot.() -> Unit) {
        executeFun()
    }
}