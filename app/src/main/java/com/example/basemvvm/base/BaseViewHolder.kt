package com.example.basemvvm.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<T, VB : ViewBinding>(
    open val binding: VB
) : RecyclerView.ViewHolder(binding.root) {

    protected var data: T? = null

    open fun onBindData(data: T) {
        this.data = data
    }
}
