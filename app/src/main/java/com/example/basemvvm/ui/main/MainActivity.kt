package com.example.basemvvm.ui.main

import com.example.basemvvm.base.BaseActivity
import com.example.basemvvm.databinding.ActivityMainBinding
import com.example.basemvvm.ui.main.adapter.BackGroundAdapter
import com.example.basemvvm.ui.main.model.BackgroundItemModel
import com.example.basemvvm.ui.main.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val viewModel by viewModel<MainViewModel>()
    private val backgroundAdapter by lazy { BackGroundAdapter() }
    override fun inflateView(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
        viewBinding.rvImage.adapter = backgroundAdapter
        viewModel.getBackground()

    }

    override fun bindView() {
        super.bindView()
    }

    override fun bindViewModel() {
        viewModel.backgroundList.observe(this) {
            val data = it.map { item ->
                BackgroundItemModel(item)
            }
            backgroundAdapter.submitList(data)
        }

    }
}