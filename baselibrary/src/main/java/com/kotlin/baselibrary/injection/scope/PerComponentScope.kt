package com.kotlin.baselibrary.injection.scope

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.RUNTIME
import javax.inject.Scope

/**
 *    author : dufeihu
 *    date   : 2019/8/29 20:22
 *    desc   :
 */
@Scope
@Documented
@Retention(RUNTIME)
annotation class PerComponentScope