package com.kotlin.baselibrary.rx

import com.kotlin.baselibrary.data.protocol.BaseResp
import io.reactivex.Observable
import io.reactivex.functions.Function

/**
 *    author : dufeihu
 *    date   : 2019/9/2 13:31
 *    desc   :
 */
open class BaseFunc<T> : Function<BaseResp<T>, Observable<T>> {
    override fun apply(t: BaseResp<T>): Observable<T> {
        if (t.success) {
            return Observable.just(t.body)
        } else {
            return Observable.error<T>(BaseException(t.errMsg, t.errCode))
        }
    }
}