package com.kotlin.usercenter.data.api

import com.kotlin.baselibrary.data.protocol.BaseResp
import com.kotlin.usercenter.data.protocal.LoginReq
import com.kotlin.usercenter.data.protocal.RegisterReq
import com.kotlin.usercenter.data.response.RegisterMobile
import com.kotlin.usercenter.data.response.UserInfo
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 *    author : dufeihu
 *    date   : 2019/8/26 19:55
 *    desc   :
 */
interface UserApi {
    @POST("plutus2-customer/info/sendVCode")
    fun register(@Body req: RegisterReq): Observable<BaseResp<RegisterMobile>>

    @POST("plutus2-customer/userBorrower/loginByMobile")
    fun login(@Body req: LoginReq): Observable<BaseResp<UserInfo>>
}
