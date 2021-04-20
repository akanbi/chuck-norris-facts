package com.akanbi.chucknorris.presentation.fact.random

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akanbi.chucknorris.domain.model.Fact
import com.akanbi.chucknorris.domain.usecase.fact.random.TellMeAFactRandomUseCase
import com.akanbi.commonandroid.getViewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class FactRandomViewModel(private val tellMeAFactRandomUseCase: TellMeAFactRandomUseCase, coroutineScope: CoroutineScope? = null) : ViewModel() {
    private val uiScope = getViewModelScope(coroutineScope)

    private var _factLiveData: MutableLiveData<Fact> = MutableLiveData()
    val factLiveData: LiveData<Fact>
        get() = _factLiveData

    fun loadFactRandom() {
        uiScope.launch {
            clearLiveData()
            tellMeAFactRandomUseCase.execute().let {
                if (it is com.akanbi.commonkotlin.ResultState.Success)
                    _factLiveData.value = it.data
            }
        }
    }

    private fun clearLiveData() {
        if (factLiveData.value != null) _factLiveData.value = Fact(factDescription = "", icon = "")
    }

}