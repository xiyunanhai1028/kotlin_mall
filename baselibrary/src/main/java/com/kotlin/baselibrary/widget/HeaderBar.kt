package com.kotlin.baselibrary.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.kotlin.baselibrary.R
import kotlinx.android.synthetic.main.header_bar_layout.view.*

/**
 *    author : dufeihu
 *    date   : 2019/9/2 15:03
 *    desc   :
 */
class HeaderBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var isShowLeftIcon = true
    private var leftTxt: String? = null
    private var titleTxt: String? = null
    private var rigthTxt: String? = null
    private var isShowRigthIcon = true

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.HeaderBar)
        isShowLeftIcon = typedArray.getBoolean(R.styleable.HeaderBar_isShowLeftIcon, true)
        leftTxt = typedArray.getString(R.styleable.HeaderBar_leftTxt)
        titleTxt = typedArray.getString(R.styleable.HeaderBar_titleTxt)
        rigthTxt = typedArray.getString(R.styleable.HeaderBar_rigthTxt)
        isShowRigthIcon = typedArray.getBoolean(R.styleable.HeaderBar_isShowRigthIcon, true)
        initView()
        typedArray.recycle()
    }

    private fun initView() {
        View.inflate(context, R.layout.header_bar_layout, this)
        backIv.visibility = if (isShowLeftIcon) View.VISIBLE else View.GONE
        leftTxt?.let {
            backTv.text = leftTxt
            backTv.visibility = View.VISIBLE
        }
        titleTxt?.let {
            titleTv.text = titleTxt
        }

        addIv.visibility = if (isShowRigthIcon) View.VISIBLE else View.GONE
        rigthTxt?.let {
            addTv.text = rigthTxt
            addTv.visibility = View.VISIBLE
        }
    }


}