package com.kotlin.usercenter.ui.activity

import android.os.Bundle
import android.widget.Toast
import com.kotlin.baselibrary.ui.activity.BaseMvpActivity
import com.kotlin.usercenter.R
import com.kotlin.usercenter.presenter.RegisterPresenter
import com.kotlin.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {
    override fun registerResult(result: Boolean) {
        Toast.makeText(this, "register success", Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mPresenter = RegisterPresenter()
        mPresenter.mView = this
        register.setOnClickListener {
            //            Toast.makeText(this, "register", Toast.LENGTH_LONG).show()
            mPresenter.register("1", "1")
        }
    }
}
