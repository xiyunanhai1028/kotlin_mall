package com.kotlin.baselibrary.injection.module

import com.trello.rxlifecycle2.LifecycleProvider
import dagger.Module
import dagger.Provides

/**
 *    author : dufeihu
 *    date   : 2019/9/2 12:13
 *    desc   :
 */
@Module
class LifecycleProvideModule(private val lifecycleProvider: LifecycleProvider<*>) {
    @Provides
    fun provideLifecycleProvide(): LifecycleProvider<*> {
        return lifecycleProvider
    }
}