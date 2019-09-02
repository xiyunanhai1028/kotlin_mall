package com.kotlin.baselibrary.presenter

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
}