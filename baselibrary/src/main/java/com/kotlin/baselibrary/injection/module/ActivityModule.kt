package com.kotlin.baselibrary.injection.module

import android.app.Activity
import dagger.Module
import dagger.Provides

/**
 *    author : dufeihu
 *    date   : 2019/8/29 20:19
 *    desc   :
 */
@Module
class ActivityModule(private val activity: Activity) {
    @Provides
    fun provideActivity(): Activity {
        return activity
    }
}