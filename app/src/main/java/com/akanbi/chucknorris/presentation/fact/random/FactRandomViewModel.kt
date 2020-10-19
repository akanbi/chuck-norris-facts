package com.akanbi.chucknorris.presentation.fact.random

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akanbi.chucknorris.domain.model.Fact
import com.akanbi.chucknorris.domain.usecase.fact.random.TellMeAFactRandomUseCase
import com.akanbi.chucknorris.presentation.util.randomGif
import kotlinx.coroutines.launch

class FactRandomViewModel(private val tellMeAFactRandomUseCase: TellMeAFactRandomUseCase) : ViewModel() {
    private var _factLiveData: MutableLiveData<Fact> = MutableLiveData()

    val factLiveData: LiveData<Fact>
        get() = _factLiveData

    fun loadFactRandom() {
        viewModelScope.launch {
            _factLiveData.value = null
            _factLiveData.value = tellMeAFactRandomUseCase.execute()
        }
    }

    fun loadGifUrl(): String = randomGif()

}