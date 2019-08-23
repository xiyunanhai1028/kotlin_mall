package com.kotlin.baselibrary.presenter

import com.kotlin.baselibrary.presenter.view.BaseView

/**
 *    author : dufeihu
 *    date   : 2019/8/23 12:36
 *    desc   :
 */
open class BasePresenter<T : BaseView> {
    lateinit var mView:T
}