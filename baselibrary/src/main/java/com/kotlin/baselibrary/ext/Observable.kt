package com.kotlin.baselibrary.ext

import android.view.View
import com.kotlin.baselibrary.rx.BaseObserver
import com.trello.rxlifecycle2.LifecycleProvider
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *    author : dufeihu
 *    date   : 2019/8/26 17:22
 *    desc   :
 */
fun <T> Observable<T>.execute(observer: BaseObserver<T>, lifecycleProvider: LifecycleProvider<*>) {
    this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .compose(lifecycleProvider.bindToLifecycle())
        .subscribe(observer)
}

fun View.onClick(method: () -> Unit) {
    this.setOnClickListener { method() }
}