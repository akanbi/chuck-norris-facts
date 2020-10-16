package com.akanbi.chucknorris.presenter.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.akanbi.chucknorris.R
import kotlinx.android.synthetic.main.activity_chuck_norris_facts.*

class ChuckNorrisFactsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chuck_norris_facts)
        
        toolbarActivity.title = resources.getString(R.string.app_name)
        setSupportActionBar(toolbarActivity)
    }
}