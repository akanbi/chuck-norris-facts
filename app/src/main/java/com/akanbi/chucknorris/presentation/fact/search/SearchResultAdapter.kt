package com.akanbi.chucknorris.presentation.fact.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akanbi.chucknorris.R
import com.akanbi.chucknorris.domain.model.Fact

class SearchResultAdapter(private val factsResult: List<com.akanbi.chucknorris.domain.model.Fact>, private val textQuery: String) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SearchResultViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_fact, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as SearchResultViewHolder).searchResultBinding
        binding?.fact = factsResult[position]
        binding?.queryResult?.text ="${binding?.root?.context?.getString(R.string.searchBy)} ${textQuery}"
        binding?.executePendingBindings()
    }

    override fun getItemCount(): Int = factsResult.size
}