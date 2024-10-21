package com.example.basemvvm.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import com.example.basemvvm.base.BaseListAdapter
import com.example.basemvvm.base.BaseViewHolder
import com.example.basemvvm.databinding.ItemBackgroundBinding
import com.example.basemvvm.ui.main.model.BackgroundItemModel
import com.example.basemvvm.util.loadImage
import com.example.basemvvm.util.tap
import com.example.basemvvm.util.toDp

class BackGroundAdapter :
    BaseListAdapter<BackgroundItemModel, ItemBackgroundBinding, BackGroundAdapter.BackGroundViewHolder>(
        diffCallback
    ) {

    private var onItemClick: (String) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BackGroundViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BackGroundViewHolder(ItemBackgroundBinding.inflate(layoutInflater, parent, false))
    }

    inner class BackGroundViewHolder(binding: ItemBackgroundBinding) :
        BaseViewHolder<BackgroundItemModel, ItemBackgroundBinding>(binding) {

        init {
            binding.root.tap {
                data?.let {
                    onItemClick(it.link)
                }
            }
        }

        override fun onBindData(data: BackgroundItemModel) {
            super.onBindData(data)
            binding.progressBar.isVisible = true
            binding.imgBackground.loadImage(data.link) {
                binding.progressBar.isVisible = false
            }
            if (data.isSelected) {
                binding.cardView.strokeWidth = 1f.toDp().toInt()
            } else {
                binding.cardView.strokeWidth = 0f.toDp().toInt()
            }
        }
    }

    fun setOnItemClick(onItemClick: (String) -> Unit) {
        this.onItemClick = onItemClick
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<BackgroundItemModel>() {
            override fun areItemsTheSame(
                oldItem: BackgroundItemModel,
                newItem: BackgroundItemModel
            ): Boolean {
                return oldItem.link == newItem.link
            }

            override fun areContentsTheSame(
                oldItem: BackgroundItemModel,
                newItem: BackgroundItemModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

}