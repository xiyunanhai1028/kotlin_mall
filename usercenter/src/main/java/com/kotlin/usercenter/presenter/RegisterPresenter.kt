package com.kotlin.usercenter.presenter

import com.kotlin.baselibrary.presenter.BasePresenter
import com.kotlin.usercenter.presenter.view.RegisterView

/**
 *    author : dufeihu
 *    date   : 2019/8/23 13:31
 *    desc   :
 */
open class RegisterPresenter:BasePresenter<RegisterView>() {
    fun register(mobile:String,code:String){
        mView.registerResult(true)
    }
}