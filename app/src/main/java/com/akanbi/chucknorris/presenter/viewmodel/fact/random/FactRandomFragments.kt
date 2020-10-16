package com.akanbi.chucknorris.presenter.viewmodel.fact.random

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.akanbi.chucknorris.R
import com.akanbi.chucknorris.databinding.RandomFactLayoutBinding
import com.akanbi.chucknorris.presenter.binding.loadData
import com.akanbi.chucknorris.presenter.util.randomGif
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.random_fact_layout.*
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class FactRandomFragments : Fragment() {

    private val factRandomViewModel: FactRandomViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val factRandomDataBinding: RandomFactLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.random_fact_layout, container, false)
        factRandomDataBinding.factRandomViewModel = factRandomViewModel
        factRandomDataBinding.lifecycleOwner = viewLifecycleOwner
        loadFact()
        return factRandomDataBinding.root
    }

    private fun loadFact() {
        lifecycleScope.launch {
            factRandomViewModel.loadFactRandom()
        }
    }


}