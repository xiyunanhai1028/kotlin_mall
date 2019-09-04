package com.kotlin.usercenter.service

import com.kotlin.usercenter.data.response.RegisterMobile
import com.kotlin.usercenter.data.response.UserInfo
import io.reactivex.Observable

/**
 *    author : dufeihu
 *    date   : 2019/8/26 15:08
 *    desc   :
 */
interface UserService {

    fun register(mobile: String): Observable<RegisterMobile>

    fun login(mobile: String, tattedId: String, tattedCode: String): Observable<UserInfo>
}