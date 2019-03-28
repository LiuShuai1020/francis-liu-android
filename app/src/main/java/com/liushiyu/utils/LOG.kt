package com.liushiyu.utils

import android.util.Log
import com.liushiyu.app.Config

class LOG {
    fun e(tag: String, string: String) {
        if (Config().getLogDebug()) {
            Log.e(tag, string)
        }
    }
}