package com.akanbi.chucknorris.domain.converter

import com.akanbi.chucknorris.domain.model.response.FactResponse
import com.akanbi.chucknorris.domain.model.Fact

fun buildFact(response: FactResponse): Fact = Fact(factDescription = response.fact, icon = response.iconUrl)