package com.kotlin.baselibrary.ui.activity

import android.os.Bundle
import com.kotlin.baselibrary.common.AppManager
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity


/**
 *    author : dufeihu
 *    date   : 2019/8/23 12:46
 *    desc   :
 */
open class BaseActivity : RxAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instant.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instant.finshActivity(this)
    }
}