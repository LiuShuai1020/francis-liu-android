package com.liushiyu.app

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.liushiyu.R
import com.liushiyu.sofia.msofia.Sofia

abstract class BaseActivity : AppCompatActivity() {

    protected abstract fun onCreateBefore()
    @LayoutRes
    protected abstract fun layoutId(): Int

    protected abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        onCreateBefore()
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        Sofia.with(this)
            .statusBarBackground(ContextCompat.getColor(this, R.color.colorStatusBar))
            .navigationBarBackground(
                ContextCompat.getColor(
                    this, R
                        .color.colorWhite
                )
            )
        initView()
    }
}