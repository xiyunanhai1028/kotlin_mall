package com.kotlin.baselibrary.data.protocol

/**
 *    author : dufeihu
 *    date   : 2019/8/26 19:50
 *    desc   :
 */
class BaseResp<out T>(val status: Int, val message: String, val data: T)