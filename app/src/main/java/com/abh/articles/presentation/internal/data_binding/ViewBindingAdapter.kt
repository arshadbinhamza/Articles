package com.abh.articles.presentation.internal.data_binding

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.abh.articles.R
import com.abh.articles.presentation.base.BaseAdapter
import com.abh.articles.presentation.base.BaseListItem
import com.abh.articles.commons.GlideApp

@BindingAdapter("showToast")
fun View.showToast(message: String?) {

    message?.let {

        setOnClickListener {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}

@BindingAdapter("loadUrl")
fun ImageView.loadUrl(url: String?) {

    url?.let { GlideApp.with(context).load(url).into(this) } ?: GlideApp.with(context)
        .load(R.mipmap.ic_launcher).into(this)
}


@Suppress("UNCHECKED_CAST")
@BindingAdapter("submitList")
fun submitList(recyclerView: RecyclerView, list: List<BaseListItem>?) {
    val adapter = recyclerView.adapter as BaseAdapter<ViewDataBinding, BaseListItem>?
    adapter?.updateData(list ?: listOf())
}

@BindingAdapter("manageState")
fun manageState(progressBar: ProgressBar, state: Boolean) {
    progressBar.visibility = if (state) View.VISIBLE else View.GONE
}