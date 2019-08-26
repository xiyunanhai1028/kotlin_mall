package com.kotlin.usercenter.presenter

import com.kotlin.baselibrary.ext.execute
import com.kotlin.baselibrary.presenter.BasePresenter
import com.kotlin.baselibrary.rx.BaseObserver
import com.kotlin.usercenter.presenter.view.RegisterView
import com.kotlin.usercenter.service.impl.UserServiceImpl

/**
 *    author : dufeihu
 *    date   : 2019/8/23 13:31
 *    desc   :
 */
open class RegisterPresenter : BasePresenter<RegisterView>() {
    fun register(mobile: String, code: String, psw: String) {
        var userService = UserServiceImpl()
        userService.register(mobile, code, psw)
            .execute(object : BaseObserver<Boolean>() {
                override fun onNext(t: Boolean) {
                    mView.registerResult(t)
                }
            })
    }
}