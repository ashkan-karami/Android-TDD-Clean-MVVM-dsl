package com.ashkan.userprofile.common.ui.adapter

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T : Any, E : BaseVH<T>>() : RecyclerView.Adapter<E>() {
    private val differCallback = object : DiffUtil.ItemCallback<T>() {

        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return onAreItemsTheSame(oldItem, newItem)
        }

        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return onAreContentsTheSame(oldItem, newItem)
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    constructor(items: ArrayList<T>) : this() {
        setData(items)
    }

    override fun getItemCount(): Int = differ.currentList.size

    fun addRangedView(items: List<T>) {
        val itemList = differ.currentList
        itemList.addAll(items)
        setData(itemList)
        notifyItemRangeInserted(differ.currentList.size - items.size, items.size)
    }

    fun setData(items: List<T>) {
        differ.submitList(items)

    }

    fun listSize() = differ.currentList.size

    fun onClearItems() {
        differ.submitList(mutableListOf())
    }

    override fun onBindViewHolder(holder: E, position: Int) {
        holder.bindData(differ.currentList[position])
    }

    abstract fun onAreItemsTheSame(oldItem: T, newItem: T): Boolean

    abstract fun onAreContentsTheSame(oldItem: T, newItem: T): Boolean
}
