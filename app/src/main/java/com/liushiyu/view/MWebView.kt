package com.liushiyu.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Build
import android.util.AttributeSet
import android.webkit.*
import com.liushiyu.app.Config
import com.liushiyu.utils.LOG

class MWebView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :

    WebView(context, attrs, defStyleAttr) {

    init {
        initView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initView() {
        webViewClient = client
        settings.javaScriptEnabled = true
        loadUrl(Config().getUrl())
    }

    private val client = object : WebViewClient() {
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            log("onPageStarted")
        }

        override fun onPageCommitVisible(view: WebView?, url: String?) {
            super.onPageCommitVisible(view, url)
            log("onPageCommitVisible")
        }
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            log("shouldOverrideUrlLoading")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                view?.loadUrl(request?.url.toString())
            } else {
                view?.loadUrl(request.toString())
            }
            return false
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            log("onPageFinished")
        }

        override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
            super.onReceivedError(view, request, error)
            log("onReceivedError")
        }

        override fun onReceivedHttpError(
            view: WebView?,
            request: WebResourceRequest?,
            errorResponse: WebResourceResponse?
        ) {
            super.onReceivedHttpError(view, request, errorResponse)
            log("onReceivedHttpError errorResponse = " + errorResponse.toString())
        }

        override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
            super.onReceivedSslError(view, handler, error)
            log("onReceivedSslError")
        }
    }

    private fun log(s: String) {
        LOG().e("MWebView", s)
    }
}


