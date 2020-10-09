package com.akanbi.chucknorris.presenter.viewstate

sealed class ViewState<out R> {

    data class Success<out T>(val data: T) : ViewState<T>()

    data class Error(val exception: Exception) : ViewState<Nothing>()

    object Loading : ViewState<Nothing>()

}