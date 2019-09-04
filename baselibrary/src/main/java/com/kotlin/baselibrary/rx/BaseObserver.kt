package com.kotlin.baselibrary.rx

import android.util.Log
import com.kotlin.baselibrary.presenter.view.BaseView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 *    author : dufeihu
 *    date   : 2019/8/26 15:49
 *    desc   :
 */
open class BaseObserver<T>(val baseView: BaseView) : Observer<T> {
    override fun onComplete() {
        baseView.hideLoading()
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: T) {

    }

    override fun onError(e: Throwable) {
        Log.d("df", "onError:" + e.toString())
        baseView.hideLoading()
        if (e is BaseException) {
            baseView.onError(e.toString())
        }
    }

}