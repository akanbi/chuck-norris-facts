package com.akanbi.chucknorris.presenter.viewmodel.fact.random

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.akanbi.chucknorris.R
import com.akanbi.chucknorris.presenter.util.randomGif
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.random_fact_layout.*
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class FactRandomFragments : Fragment() {

    private val factRandomViewModel: FactRandomViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadFact()
    }

    private fun loadFact() {
        lifecycleScope.launch {
            factRandomViewModel.loadFactRandom()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.random_fact_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
    }

    private fun initObserver() {
        factRandomViewModel.factLiveData.observe(viewLifecycleOwner, Observer {
            val html = "<html><body><p align=\"justify\" style=\"font-size:10px\">${it.factDescription}</p></body></html>";
            factDescription.loadData(html, "text/html", "utf-8")

            Glide.with(this)
                .load(randomGif())
                .into(gifChuckNorris)
        })
    }

}