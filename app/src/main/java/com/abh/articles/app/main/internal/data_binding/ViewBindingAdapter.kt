package com.abh.articles.app.main.internal.data_binding

import android.view.View
import android.widget.Toast
import androidx.databinding.BindingAdapter

@BindingAdapter("showToast")
fun View.showToast(message: String?) {

    message?.let {

        setOnClickListener {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}