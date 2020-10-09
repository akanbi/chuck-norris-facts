package com.akanbi.chucknorris.presenter.viewmodel.fact.random

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akanbi.chucknorris.domain.model.Fact
import com.akanbi.chucknorris.domain.usecase.fact.random.TellMeAFactRandomUseCase
import kotlinx.coroutines.launch

class FactRandomViewModel(private val tellMeAFactRandomUseCase: TellMeAFactRandomUseCase) : ViewModel() {

    var factLiveData: MutableLiveData<Fact> = MutableLiveData()

    fun loadFactRandom() {
        viewModelScope.launch {
            factLiveData.postValue(tellMeAFactRandomUseCase.execute())
        }
    }

}