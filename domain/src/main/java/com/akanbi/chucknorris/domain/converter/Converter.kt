package com.akanbi.chucknorris.domain.converter

interface Converter<in T, out E> {

    fun convert(toConvert : T) : E

}