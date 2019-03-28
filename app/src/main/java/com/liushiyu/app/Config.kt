package com.liushiyu.app

import com.liushiyu.BuildConfig

class Config {
    fun getUrl() : String {
        return BuildConfig.WEB_VIEW_URL
    }

    fun getLogDebug() : Boolean {
        return BuildConfig.LOG_DEBUG
    }
}