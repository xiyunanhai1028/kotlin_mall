package com.kotlin.baselibrary.common

import android.app.Application
import android.content.Context
import com.kotlin.baselibrary.injection.component.AppComponent
import com.kotlin.baselibrary.injection.component.DaggerAppComponent
import com.kotlin.baselibrary.injection.module.AppModule

/**
 *    author : dufeihu
 *    date   : 2019/8/29 20:12
 *    desc   :
 */
class BaseApplication : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        initInjection()
        context = this
    }

    private fun initInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object {
        lateinit var context: Context;
    }
}