package com.kotlin.baselibrary.ui.activity

import com.kotlin.baselibrary.presenter.BasePresenter
import com.kotlin.baselibrary.presenter.view.BaseView

/**
 *    author : dufeihu
 *    date   : 2019/8/23 12:47
 *    desc   :
 */
open class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {
    lateinit var mPresenter: T
    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError() {

    }
}