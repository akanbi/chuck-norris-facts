package com.akanbi.chucknorris.presentation.fact.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akanbi.chucknorris.domain.model.Fact
import com.akanbi.chucknorris.domain.usecase.fact.search.SearchMeAFactUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchFactsViewModel(private val searchMeAFactUseCase: SearchMeAFactUseCase) : ViewModel() {
    private var _factsListLiveData: MutableLiveData<List<Fact>> = MutableLiveData()

    val factsListLiveData: LiveData<List<Fact>>
        get() = _factsListLiveData

    fun search(query: String) {
        viewModelScope.launch {
            _factsListLiveData.value = searchMeAFactUseCase.execute(query)
        }
    }

}