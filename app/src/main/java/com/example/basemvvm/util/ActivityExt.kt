package com.example.basemvvm.util

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.basemvvm.R


fun AppCompatActivity.replaceFragment(fragment: Fragment, containerId: Int, tag: String? = null) {
    supportFragmentManager.commit {
        setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
        replace(containerId, fragment, tag)
    }
}

inline fun <reified T : Fragment> AppCompatActivity.replaceFragmentIfNotExit(
    fragment: T,
    containerId: Int,
    tag: String? = null,
    onExist: (T) -> Unit = {}
) {
    supportFragmentManager.fragments.forEach {
        if (it is T && it.isVisible) {
            onExist(it)
            return
        }
    }
    supportFragmentManager.commit {
        setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
        replace(containerId, fragment, tag)
    }
}

fun AppCompatActivity.removeFragment(fragment: Fragment) {
    supportFragmentManager.commit {
        remove(fragment)
    }
}
