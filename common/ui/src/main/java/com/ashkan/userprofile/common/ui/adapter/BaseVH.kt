package com.ashkan.userprofile.common.ui.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseVH<T>(B: ViewDataBinding): RecyclerView.ViewHolder(B.root)
{
    abstract fun bindData(item: T)
}
