package com.kotlin.baselibrary.ext

import android.view.View
import android.widget.Button
import android.widget.EditText
import com.kotlin.baselibrary.rx.BaseObserver
import com.kotlin.baselibrary.widget.DefaultTextWatcher
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

fun Button.enable(et: EditText, method: () -> Boolean) {
    var btn = this
    et.addTextChangedListener(object : DefaultTextWatcher() {
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            btn.isEnabled = method()
        }
    })
}