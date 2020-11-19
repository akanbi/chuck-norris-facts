package com.akanbi.chucknorris

import android.view.KeyEvent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

abstract class BaseRobot {

    fun clickButtonBy(id: Int) {
        onView(withId(id)).perform(click())
    }

    fun typeTextBy(hint: String, text: String) {
        onView(withHint(hint)).perform(typeText(text), closeSoftKeyboard())
    }

    fun checkMessage(message: String) {
        onView(withText(message)).check(matches(isDisplayed()))
    }

    fun pressEnter() {
        onView(isRoot()).perform(pressKey(KeyEvent.KEYCODE_ENTER))
    }

    fun sleep(time: Long) = apply {
        Thread.sleep(time)
    }



}