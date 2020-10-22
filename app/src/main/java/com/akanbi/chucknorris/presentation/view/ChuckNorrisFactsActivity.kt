package com.akanbi.chucknorris.presentation.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.akanbi.chucknorris.R
import com.akanbi.chucknorris.presentation.fact.random.FactRandomFragments
import com.akanbi.chucknorris.presentation.fact.search.SearchFactFragment
import com.akanbi.chucknorris.presentation.util.fragmentTransaction

class ChuckNorrisFactsActivity : AppCompatActivity() {

    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chuck_norris_facts)

        initFactRandomFragment()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_facts, menu)
        searchView = menu?.findItem(R.id.search_facts)?.actionView as SearchView
        searchView.queryHint = getString(R.string.searchHint)
        searchView.setOnQueryTextListener(onQueryText())
        return true
    }

    private fun initSearchFactFragment(query: String) {
        fragmentTransaction {
            addToBackStack(null)
            replace(R.id.fragmentContainer, SearchFactFragment(query))
        }
    }

    private fun initFactRandomFragment() {
        fragmentTransaction {
            replace(R.id.fragmentContainer, FactRandomFragments())
        }
    }

    private fun onQueryText() = object : SearchView.OnQueryTextListener {
        override fun onQueryTextChange(newText: String?): Boolean {
            return false
        }

        override fun onQueryTextSubmit(query: String?): Boolean {
            if (query != null) {
                initSearchFactFragment(query)
                searchView.onActionViewCollapsed()
            }
            return true
        }
    }
}