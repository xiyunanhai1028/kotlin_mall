package com.kotlin.usercenter.service

import com.kotlin.baselibrary.data.protocol.BaseResp
import com.kotlin.usercenter.data.response.UserInfo
import io.reactivex.Observable

/**
 *    author : dufeihu
 *    date   : 2019/8/26 15:08
 *    desc   :
 */
interface UserService {
    fun register(mobile: String, code: String, psw: String): Observable<UserInfo>
}