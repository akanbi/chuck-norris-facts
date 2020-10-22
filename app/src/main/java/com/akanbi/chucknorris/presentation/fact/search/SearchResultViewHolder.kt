package com.akanbi.chucknorris.presentation.fact.search

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.akanbi.chucknorris.databinding.ItemFactBinding

class SearchResultViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val searchResultBinding: ItemFactBinding? = DataBindingUtil.bind(view)

}