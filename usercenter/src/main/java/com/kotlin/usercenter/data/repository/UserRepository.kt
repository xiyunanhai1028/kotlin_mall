package com.kotlin.usercenter.data.repository

import com.kotlin.baselibrary.data.net.RetrofitFactory
import com.kotlin.baselibrary.data.protocol.BaseResp
import com.kotlin.usercenter.data.api.UserApi
import com.kotlin.usercenter.data.protocal.RegisterReq
import com.kotlin.usercenter.data.response.UserInfo
import io.reactivex.Observable
import javax.inject.Inject

/**
 *    author : dufeihu
 *    date   : 2019/8/26 20:11
 *    desc   :
 */
class UserRepository @Inject constructor(){
    fun register(mobile: String, code: String, psw: String): Observable<BaseResp<UserInfo>> {
        return RetrofitFactory.instant.create(UserApi::class.java).register(RegisterReq(mobile, code, psw))
    }
}