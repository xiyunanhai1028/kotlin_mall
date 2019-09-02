package com.kotlin.baselibrary.data.protocol

/**
 *    author : dufeihu
 *    date   : 2019/8/26 19:50
 *    desc   :
 */
class BaseResp<out T>(val success: Boolean, val errMsg: String,val errCode:String, val body: T)