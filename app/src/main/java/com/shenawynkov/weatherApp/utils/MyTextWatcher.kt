package com.shenawynkov.weatherApp.utils

import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.MutableLiveData

class MyTextWatcher(

    val func: (city: String) -> Unit
) : TextWatcher {
    private  var runnable:Runnable= Runnable {

    }
    private val  handler: Handler = Handler()

    val late = 1500L


    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        handler.removeCallbacks(runnable)
         runnable = Runnable {
            if (s.isNullOrEmpty())
                return@Runnable
            func(s.toString())


        }

        handler.postDelayed(runnable, late)

    }
}