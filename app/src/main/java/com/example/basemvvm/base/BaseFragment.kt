package com.example.basemvvm.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    protected lateinit var binding: VB

    abstract fun inflateViewBinding(): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateViewBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        bindView()
        bindViewModel()
    }

    open fun initView() {
    }

    open fun bindView() {}

    open fun bindViewModel() {}

    protected fun hideSoftKeyboard() {
        activity?.currentFocus?.windowToken?.let {
            activity?.getSystemService(InputMethodManager::class.java)
                ?.hideSoftInputFromWindow(it, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

    protected fun toast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    fun hideView(view: View) {
        view.visibility = View.GONE
    }

    fun showView(view: View) {
        view.visibility = View.VISIBLE
    }

    fun invisibleView(view: View) {
        view.visibility = View.INVISIBLE
    }
}
