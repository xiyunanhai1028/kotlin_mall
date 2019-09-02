package com.kotlin.baselibrary.injection.component

import android.app.Activity
import android.content.Context
import com.kotlin.baselibrary.injection.module.ActivityModule
import com.kotlin.baselibrary.injection.module.LifecycleProvideModule
import com.kotlin.baselibrary.injection.scope.ActivityScope
import com.trello.rxlifecycle2.LifecycleProvider
import dagger.Component

/**
 *    author : dufeihu
 *    date   : 2019/8/29 20:21
 *    desc   :
 */
@ActivityScope
@Component(
    dependencies = arrayOf(AppComponent::class),
    modules = arrayOf(ActivityModule::class, LifecycleProvideModule::class)
)
interface ActivityComponent {
    fun context(): Context
    fun activity(): Activity
    fun lifecycleProvider(): LifecycleProvider<*>

}