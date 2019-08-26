package com.kotlin.usercenter.data.repository

import com.kotlin.baselibrary.data.net.RetrofitFactory
import com.kotlin.baselibrary.data.protocol.BaseResp
import com.kotlin.usercenter.data.api.UserApi
import com.kotlin.usercenter.data.protocal.RegisterReq
import io.reactivex.Observable

/**
 *    author : dufeihu
 *    date   : 2019/8/26 20:11
 *    desc   :
 */
class UserRepository {
    fun register(mobile: String, code: String, psw: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instant.create(UserApi::class.java).register(RegisterReq(mobile, code, psw))
    }
}