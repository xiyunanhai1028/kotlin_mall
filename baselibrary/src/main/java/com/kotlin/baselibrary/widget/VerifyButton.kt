package com.kotlin.baselibrary.widget

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import android.widget.Button
import com.kotlin.baselibrary.R

/**
 *    author : dufeihu
 *    date   : 2019/9/3 12:10
 *    desc   :
 */
class VerifyButton(context: Context, attrs: AttributeSet) : Button(context, attrs) {
    private var mHandler: Handler
    private var mCount = 60
    private var mOnVerifyBtnClick: OnVerifyBtnClick? = null

    init {
        this.text = "获取验证码"
        mHandler = Handler()
    }

    //倒计时，并处理点击事件
    fun requestSendVerifyNumber() {
        mHandler.postDelayed(countDown, 0)
        if (mOnVerifyBtnClick != null) {
            mOnVerifyBtnClick!!.onClick()
        }
    }

    //倒计时
    private val countDown = object : Runnable {
        override fun run() {
            this@VerifyButton.text = mCount.toString() + " s"
            this@VerifyButton.setBackgroundColor(resources.getColor(R.color.common_disable))
            this@VerifyButton.setTextColor(resources.getColor(R.color.common_white))
            this@VerifyButton.isClickable = false

            if (mCount > 0) {
                mHandler?.postDelayed(this, 1000)
            } else {
                resetCounter()
            }
            mCount--
        }
    }

    fun resetCounter(vararg text: String) {
        this.isClickable = true
        if (text.isNotEmpty() && "" != text[0]) {
            this.text = text[0]
        } else {
            this.text = "重获验证码"
        }
        this.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        this.setTextColor(resources.getColor(R.color.txt_fff))
        mCount = 60
    }

    fun removeRunable() {
        mHandler.removeCallbacks(countDown)
    }

    /**
     * 点击事件接口
     */
    interface OnVerifyBtnClick {
        fun onClick()
    }

    fun setOnVerifyBtnClick(listener: OnVerifyBtnClick) {
        mOnVerifyBtnClick = listener
    }
}