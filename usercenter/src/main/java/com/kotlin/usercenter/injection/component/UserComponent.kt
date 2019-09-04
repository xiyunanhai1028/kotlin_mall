package com.kotlin.usercenter.injection.component

import com.kotlin.baselibrary.injection.component.ActivityComponent
import com.kotlin.baselibrary.injection.scope.PerComponentScope
import com.kotlin.usercenter.injection.module.UserModule
import com.kotlin.usercenter.ui.activity.LoginActivity
import com.kotlin.usercenter.ui.activity.RegisterActivity
import dagger.Component

/**
 *    author : dufeihu
 *    date   : 2019/8/29 18:36
 *    desc   :
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class), modules = arrayOf(UserModule::class))
interface UserComponent {
    fun inject(registerActivity: RegisterActivity)
    fun inject(loginActivity: LoginActivity)
}