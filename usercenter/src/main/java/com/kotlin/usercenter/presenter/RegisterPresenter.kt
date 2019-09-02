package com.kotlin.usercenter.presenter

import com.kotlin.baselibrary.ext.execute
import com.kotlin.baselibrary.presenter.BasePresenter
import com.kotlin.baselibrary.rx.BaseObserver
import com.kotlin.usercenter.data.response.UserInfo
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

    fun register(mobile: String, code: String, psw: String) {
        userService.register(mobile, code, psw)
            .execute(object : BaseObserver<UserInfo>() {
                override fun onNext(t: UserInfo) {
                    mView.registerResult(t)
                }
//                override fun onNext(t: BaseResp<UserInfo>) {
//                    if (t.success) {
//                        mView.registerResult(t.success)
//                    } else {
//                        Observable.error<Throwable>(BaseException(t.errMsg, t.errCode))
//                    }
//                }
            }, lifecycleProvider)
    }
}