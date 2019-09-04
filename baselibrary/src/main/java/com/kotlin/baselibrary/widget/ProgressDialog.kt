package com.kotlin.baselibrary.widget

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import com.kotlin.baselibrary.R

/**
 *    author : dufeihu
 *    date   : 2019/9/2 17:01
 *    desc   :
 */
class ProgressDialog private constructor(context: Context, theme: Int) : Dialog(context, theme) {
    companion object {
        private lateinit var mDialog: ProgressDialog
        fun create(context: Context): ProgressDialog {
            mDialog = ProgressDialog(context, R.style.LightProgressDialog)
            mDialog.setContentView(R.layout.progress_dialog)
            mDialog.setCancelable(true)
            mDialog.setCanceledOnTouchOutside(false)
            val lp = mDialog.window.attributes
            lp.gravity = Gravity.CENTER
            lp.dimAmount = 0.2f
            mDialog.window.attributes = lp
            return mDialog
        }
    }

    fun showLoading() {
        mDialog.show()
    }

    fun cancelLoading() {
        mDialog.dismiss()
    }
}