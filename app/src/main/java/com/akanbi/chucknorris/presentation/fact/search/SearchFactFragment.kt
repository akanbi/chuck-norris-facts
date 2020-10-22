package com.akanbi.chucknorris.presentation.fact.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.akanbi.chucknorris.R
import com.akanbi.chucknorris.databinding.FactsListQueryLayoutBinding
import com.akanbi.chucknorris.presentation.util.showContentOnImageView
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class SearchFactFragment(private val textForQuery: String) : Fragment() {

    private val searchFactsViewModel: SearchFactsViewModel by viewModel()
    private lateinit var searchBinding: FactsListQueryLayoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        searchBinding = DataBindingUtil.inflate(inflater, R.layout.facts_list_query_layout, container, false)
        searchBinding.lifecycleOwner = viewLifecycleOwner
        searchBinding.searchFactViewModel = searchFactsViewModel
        search()
        setObserver()
        setIconsForLoadList()
        return searchBinding.root
    }

    private fun search() {
        lifecycleScope.launch {
            searchFactsViewModel.search(textForQuery)
        }
    }

    private fun setObserver() {
        searchFactsViewModel.factsListLiveData.observe(viewLifecycleOwner, Observer {
            val factList = searchBinding.factList
            factList.layoutManager = LinearLayoutManager(searchBinding.root.context)
            factList.adapter = SearchResultAdapter(it, textForQuery)
        })
    }

    private fun setIconsForLoadList() {
        showContentOnImageView(searchBinding.loadIcon, "https://i.gifer.com/9B5G.gif")
        showContentOnImageView(searchBinding.loadTextIcon, "https://midcoast.libero.com.au/libhist/Styles/Greatlakes/images/loading_animation.gif")
    }

}