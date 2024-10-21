package com.example.basemvvm.util

import android.content.Intent
import android.view.View
import com.example.basemvvm.ui.main.MainActivity


fun View.tap(action: (view: View?) -> Unit) {
    setOnClickListener(object : TapListener() {
        override fun onTap(v: View?) {
            try {
                if (!CheckInternet.haveNetworkConnection(context)) {
                    context.findActivity()?.let {
                        //Sua thanh activity NoInternet
                        val intent = Intent(it, MainActivity::class.java)
                        it.startActivity(intent)
                        it.overridePendingTransition(0, 0)
                    }
                } else {
                    action(v)
                }
            }catch (e : Exception){
                e.printStackTrace()
            }
        }
    })
}