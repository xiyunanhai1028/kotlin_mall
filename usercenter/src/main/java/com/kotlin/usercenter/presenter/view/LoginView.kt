package com.kotlin.usercenter.presenter.view

import com.kotlin.baselibrary.presenter.view.BaseView

/**
 *    author : dufeihu
 *    date   : 2019/9/3 19:12
 *    desc   :
 */
interface LoginView:BaseView {
    fun loginResult(tokenId:String)
}