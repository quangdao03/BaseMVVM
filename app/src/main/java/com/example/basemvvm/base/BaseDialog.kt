package com.example.basemvvm.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding
import com.example.basemvvm.R


abstract class BaseDialog<T : ViewBinding>(context: Context) :
    Dialog(context, R.style.full_screen_dialog) {
    lateinit var binding: T

    private fun getInflatedLayoutNew(inflater: LayoutInflater): View {
        binding = setBinding(inflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getInflatedLayoutNew(layoutInflater))
        initView()
        listener()
        setCancelable(true)
        setCanceledOnTouchOutside(false)
    }

    abstract fun setBinding(layoutInflater: LayoutInflater): T

    abstract fun initView()
    abstract fun listener()

}