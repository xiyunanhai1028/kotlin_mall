package com.kotlin.baselibrary.ext

import com.kotlin.baselibrary.rx.BaseObserver
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *    author : dufeihu
 *    date   : 2019/8/26 17:22
 *    desc   :
 */
fun <T> Observable<T>.execute(observer: BaseObserver<T>) {
    this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer)
}