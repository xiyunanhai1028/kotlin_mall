package com.kotlin.usercenter.presenter

import com.kotlin.baselibrary.ext.execute
import com.kotlin.baselibrary.presenter.BasePresenter
import com.kotlin.baselibrary.rx.BaseObserver
import com.kotlin.usercenter.data.response.RegisterMobile
import com.kotlin.usercenter.presenter.view.RegisterView
import com.kotlin.usercenter.service.impl.UserServiceImpl
import javax.inject.Inject

/**
 *    author : dufeihu
 *    date   : 2019/8/23 13:31
 *    desc   :
 */
open class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {
    @Inject
    lateinit var userService: UserServiceImpl

    fun register(mobile: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        userService.register(mobile)
            .execute(object : BaseObserver<RegisterMobile>(mView) {
                override fun onNext(t: RegisterMobile) {
                    mView.registerResult(t.tattedId)
                }
            }, lifecycleProvider)
    }
}