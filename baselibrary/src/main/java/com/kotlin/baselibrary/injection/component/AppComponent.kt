package com.kotlin.baselibrary.injection.component

import android.content.Context
import com.kotlin.baselibrary.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 *    author : dufeihu
 *    date   : 2019/8/29 20:18
 *    desc   :
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun context(): Context
}