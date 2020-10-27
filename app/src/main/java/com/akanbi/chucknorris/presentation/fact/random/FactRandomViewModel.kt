package com.akanbi.chucknorris.presentation.fact.random

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akanbi.chucknorris.domain.model.Fact
import com.akanbi.chucknorris.domain.usecase.fact.random.TellMeAFactRandomUseCase
import com.akanbi.chucknorris.presentation.util.getViewModelScope
import com.akanbi.chucknorris.presentation.util.randomGif
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class FactRandomViewModel(private val tellMeAFactRandomUseCase: TellMeAFactRandomUseCase, coroutineScope: CoroutineScope? = null) : ViewModel() {
    private var _factLiveData: MutableLiveData<Fact> = MutableLiveData()
    private val uiScope = getViewModelScope(coroutineScope)

    val factLiveData: LiveData<Fact>
        get() = _factLiveData

    fun loadFactRandom() {
        uiScope.launch {
            clearLiveData()
            val factReturned = tellMeAFactRandomUseCase.execute()
            _factLiveData.value = factReturned
        }
    }

    private fun clearLiveData() {
        if (factLiveData.value != null) _factLiveData.value = Fact(factDescription = "", icon = "")
    }

}