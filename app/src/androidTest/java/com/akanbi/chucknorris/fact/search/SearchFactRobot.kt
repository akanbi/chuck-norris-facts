package com.akanbi.chucknorris.fact.search

import com.akanbi.chucknorris.BaseRobot
import com.akanbi.chucknorris.R

fun search(executeFun: SearchFactRobot.() -> Unit) = SearchFactRobot().apply{ executeFun() }

class SearchFactRobot : BaseRobot() {

    fun clickSearch() {
        clickButtonBy(R.id.search_facts)
    }

    fun typeContentBySearch(query: String) {
        typeTextBy("Type your search", query)
    }

    fun checkContentBy(query: String) {
//        checkMessage(query)
    }

    infix fun verify(executeFun: SearchFactRobot.() -> Unit) {
        executeFun()
    }

}