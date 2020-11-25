package com.akanbi.chucknorris.common

import java.lang.Exception

sealed class ResultState<out T> {

    data class Success<out T>(val data: T) : ResultState<T>()

    data class Error(val exception: Exception) : ResultState<Nothing>()

    object Loading : ResultState<Nothing>()

}