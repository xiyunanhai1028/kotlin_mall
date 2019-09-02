package com.kotlin.usercenter.presenter.view

import com.kotlin.baselibrary.presenter.view.BaseView
import com.kotlin.usercenter.data.response.UserInfo

/**
 *    author : dufeihu
 *    date   : 2019/8/23 13:31
 *    desc   :
 */
interface RegisterView : BaseView {
    fun registerResult(result: UserInfo)
}