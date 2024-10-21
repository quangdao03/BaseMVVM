package com.example.basemvvm.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.basemvvm.R


inline fun<reified T: Fragment> Fragment.replaceFragmentIfNotExit(fragment: T, containerId: Int, tag: String? = null) {
    childFragmentManager.fragments.forEach {
        if (it is T && it.isVisible) return
    }
    childFragmentManager.commit {
        setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
        replace(containerId, fragment, tag)
    }
}