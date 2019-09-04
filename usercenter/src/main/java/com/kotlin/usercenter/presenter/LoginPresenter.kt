package com.kotlin.usercenter.presenter

import com.google.gson.Gson
import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.baselibrary.ext.execute
import com.kotlin.baselibrary.presenter.BasePresenter
import com.kotlin.baselibrary.rx.BaseObserver
import com.kotlin.usercenter.data.response.UserInfo
import com.kotlin.usercenter.presenter.view.LoginView
import com.kotlin.usercenter.service.impl.UserServiceImpl
import javax.inject.Inject

/**
 *    author : dufeihu
 *    date   : 2019/9/3 19:13
 *    desc   :
 */
class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {
    @Inject
    lateinit var userService: UserServiceImpl

    fun login(mobile: String, tattedId: String, tattedCode: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        userService.login(mobile, tattedId, tattedCode)
            .execute(object : BaseObserver<UserInfo>(mView) {
                override fun onNext(t: UserInfo) {
                    saveUserInfo(t)
                    mView.loginResult(t.tokenId)
                }
            }, lifecycleProvider)
    }

    /**
     * 保存用户信息
     */
    fun saveUserInfo(userInfo: UserInfo) {
        if (userInfo != null && !userInfo.equals("")) {
            AppPrefsUtils.putString("userInfo", Gson().toJson(userInfo))
        }
    }

    /**
     * 清除用户信息
     */
    fun clearUserInfo() {
        val userInfo = AppPrefsUtils.getString("userInfo")
        if (userInfo.isNullOrEmpty().not()) {
            AppPrefsUtils.remove("userInfo")
        }
    }
}