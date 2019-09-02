package com.kotlin.baselibrary.rx

import android.util.Log
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 *    author : dufeihu
 *    date   : 2019/8/26 15:49
 *    desc   :
 */
open class BaseObserver<T> : Observer<T> {
    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: T) {

    }

    override fun onError(e: Throwable) {
        Log.d("df", "onError:" + e.toString())
    }

}