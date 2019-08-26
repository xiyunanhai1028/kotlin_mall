package com.kotlin.usercenter.service.impl

import com.kotlin.usercenter.service.UserService
import io.reactivex.Observable

/**
 *    author : dufeihu
 *    date   : 2019/8/26 15:10
 *    desc   :
 */
class UserServiceImpl : UserService {
    override fun register(mobile: String, code: String, psw: String): Observable<Boolean> {
        return Observable.just(true)
    }


}