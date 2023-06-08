package com.ashkan.userprofile.features.login.login_feature.ui

import android.view.View
import androidx.databinding.BindingAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@BindingAdapter("ui:click")
fun View.setClick(action: (() -> Unit)?) {
    this.setOnClickListener {
        CoroutineScope(Main).launch {
            it.isClickable = false
            action?.invoke()
            delay(200)
            it.isClickable = true
        }
    }
}

