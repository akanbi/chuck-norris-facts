package com.akanbi.chucknorris.presentation.fact.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akanbi.chucknorris.common.ResultState
import com.akanbi.chucknorris.domain.model.Fact
import com.akanbi.chucknorris.domain.usecase.fact.search.SearchMeAFactUseCase
import com.akanbi.chucknorris.presentation.util.getViewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class SearchFactsViewModel(private val searchMeAFactUseCase: SearchMeAFactUseCase, coroutineScope: CoroutineScope? = null) : ViewModel() {
    private val uiScope = getViewModelScope(coroutineScope)

    private var _factsListLiveData: MutableLiveData<List<Fact>> = MutableLiveData()
    val factsListLiveData: LiveData<List<Fact>>
        get() = _factsListLiveData

    fun search(query: String) {
        uiScope.launch {
            val facts = (searchMeAFactUseCase.execute(query) as ResultState.Success).data
            _factsListLiveData.value = facts
        }
    }

}