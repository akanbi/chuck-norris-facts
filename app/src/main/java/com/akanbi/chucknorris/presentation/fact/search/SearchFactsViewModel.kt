package com.akanbi.chucknorris.presentation.fact.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akanbi.chucknorris.domain.model.Fact
import com.akanbi.chucknorris.domain.usecase.fact.search.SearchMeAFactUseCase
import com.akanbi.chucknorris.presentation.util.getViewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchFactsViewModel(private val searchMeAFactUseCase: com.akanbi.chucknorris.domain.usecase.fact.search.SearchMeAFactUseCase, coroutineScope: CoroutineScope? = null) : ViewModel() {
    private var _factsListLiveData: MutableLiveData<List<com.akanbi.chucknorris.domain.model.Fact>> = MutableLiveData()
    private val uiScope = getViewModelScope(coroutineScope)

    val factsListLiveData: LiveData<List<com.akanbi.chucknorris.domain.model.Fact>>
        get() = _factsListLiveData

    fun search(query: String) {
        uiScope.launch {
            _factsListLiveData.value = searchMeAFactUseCase.execute(query)
        }
    }

}