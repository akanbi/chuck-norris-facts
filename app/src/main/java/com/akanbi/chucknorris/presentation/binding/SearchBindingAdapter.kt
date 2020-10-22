package com.akanbi.chucknorris.presentation.binding

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.akanbi.chucknorris.domain.model.Fact

@BindingAdapter("android:visibility")
fun showLoadListResult(constraintLayout: ConstraintLayout, list: List<Fact>?) {
    constraintLayout.visibility = if (list.isNullOrEmpty()) View.VISIBLE else View.GONE
}

@BindingAdapter("android:visibility")
fun showListResult(recyclerView: RecyclerView, list: List<Fact>?) {
    recyclerView.visibility = if (list != null && list.isNotEmpty()) View.VISIBLE else View.GONE
}
