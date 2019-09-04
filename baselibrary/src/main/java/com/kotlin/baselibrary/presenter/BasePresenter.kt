package com.kotlin.baselibrary.presenter

import android.content.Context
import com.kotlin.base.utils.NetWorkUtils
import com.kotlin.baselibrary.presenter.view.BaseView
import com.trello.rxlifecycle2.LifecycleProvider
import javax.inject.Inject

/**
 *    author : dufeihu
 *    date   : 2019/8/23 12:36
 *    desc   :
 */
open class BasePresenter<T : BaseView> {
    lateinit var mView: T

    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var context: Context

    fun checkNetWork(): Boolean {
        if (NetWorkUtils.isNetWorkAvailable(context)) {
            return true
        }
        mView.onError("请检查网络！！")
        return false
    }
}