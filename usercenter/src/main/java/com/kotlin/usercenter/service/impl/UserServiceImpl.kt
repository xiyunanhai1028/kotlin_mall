package com.kotlin.usercenter.service.impl

import com.kotlin.baselibrary.rx.BaseFunc
import com.kotlin.usercenter.data.repository.UserRepository
import com.kotlin.usercenter.data.response.RegisterMobile
import com.kotlin.usercenter.data.response.UserInfo
import com.kotlin.usercenter.service.UserService
import io.reactivex.Observable
import javax.inject.Inject

/**
 *    author : dufeihu
 *    date   : 2019/8/26 15:10
 *    desc   :
 */
class UserServiceImpl @Inject constructor() : UserService {


    @Inject
    lateinit var repository: UserRepository

    /**
     * 获取验证码
     */
    override fun register(mobile: String): Observable<RegisterMobile> {
        return repository.register(mobile).flatMap(BaseFunc<RegisterMobile>())
    }

    /**
     * 登录
     */
    override fun login(mobile: String, tattedId: String, tattedCode: String): Observable<UserInfo> {
        return repository.login(mobile, tattedId, tattedCode).flatMap(BaseFunc<UserInfo>())
    }

}