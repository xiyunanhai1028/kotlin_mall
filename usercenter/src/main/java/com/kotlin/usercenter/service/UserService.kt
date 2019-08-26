package com.kotlin.usercenter.service

import io.reactivex.Observable

/**
 *    author : dufeihu
 *    date   : 2019/8/26 15:08
 *    desc   :
 */
interface UserService {
    fun register(mobile:String,code:String,psw:String):Observable<Boolean>
}