package com.akanbi.chucknorris.presentation.util

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

fun AppCompatActivity.fragmentTransaction(execute: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = supportFragmentManager.beginTransaction()
    execute(fragmentTransaction)
    fragmentTransaction.commit()
}