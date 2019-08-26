package com.kotlin.usercenter.data.api

import com.kotlin.baselibrary.data.protocol.BaseResp
import com.kotlin.usercenter.data.protocal.RegisterReq
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 *    author : dufeihu
 *    date   : 2019/8/26 19:55
 *    desc   :
 */
interface UserApi {
    @POST("userCenter/register")
    fun register(@Body req: RegisterReq): Observable<BaseResp<String>>
}
