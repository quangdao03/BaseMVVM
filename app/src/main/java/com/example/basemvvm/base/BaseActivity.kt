package com.example.basemvvm.base

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.viewbinding.ViewBinding
import com.example.basemvvm.util.LocaleHelper
import com.example.basemvvm.util.SharePref

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    protected lateinit var viewBinding: VB

    abstract fun inflateView(): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = inflateView()
        setContentView(viewBinding.root)
        hideNavigationBar()
        initView()
        bindView()
        bindViewModel()
    }

    open fun initView() {}

    open fun bindView() {}

    open fun bindViewModel() {}

    override fun attachBaseContext(newBase: Context?) {
        val newContext = newBase?.let {
            val languageCode = SharePref.getString(it, SharePref.LANGUAGE, "en")
            LocaleHelper.changeTo(languageCode, it)
        }
        super.attachBaseContext(newContext)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q) {
            hideNavigationBarInLowerAndroid()
        }
    }

    protected fun hideSoftKeyboard() {
        viewBinding.root.windowToken?.let {
            getSystemService(InputMethodManager::class.java)
                ?.hideSoftInputFromWindow(it, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

    protected fun lightStatusBar() {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q) {
            val flag = window.decorView.systemUiVisibility
            window.decorView.systemUiVisibility = flag or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    private fun hideNavigationBar() {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q) {
            hideNavigationBarInLowerAndroid()
        } else {
            WindowCompat.setDecorFitsSystemWindows(window, false)
            WindowInsetsControllerCompat(window, viewBinding.root).let { controller ->
                controller.hide(WindowInsetsCompat.Type.navigationBars())
                controller.systemBarsBehavior =
                    WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        }
    }

    private fun hideNavigationBarInLowerAndroid() {
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
    }

    protected fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
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
