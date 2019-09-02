package com.kotlin.usercenter.service.impl

import com.kotlin.baselibrary.rx.BaseFunc
import com.kotlin.usercenter.data.repository.UserRepository
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

    override fun register(mobile: String, code: String, psw: String): Observable<UserInfo> {
        return repository.register(mobile, code, psw).flatMap(BaseFunc<UserInfo>())
    }


}