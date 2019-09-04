package com.kotlin.baselibrary.presenter.view

/**
 *    author : dufeihu
 *    date   : 2019/8/23 12:37
 *    desc   :
 */
interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(text:String)
}