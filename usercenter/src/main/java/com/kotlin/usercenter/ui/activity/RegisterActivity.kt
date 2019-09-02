package com.kotlin.usercenter.ui.activity

import android.os.Bundle
import android.widget.Toast
import com.kotlin.baselibrary.common.AppManager
import com.kotlin.baselibrary.ext.onClick
import com.kotlin.baselibrary.ui.activity.BaseMvpActivity
import com.kotlin.usercenter.R
import com.kotlin.usercenter.data.response.UserInfo
import com.kotlin.usercenter.injection.component.DaggerUserComponent
import com.kotlin.usercenter.presenter.RegisterPresenter
import com.kotlin.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {
    private var pressTime: Long = 0
    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(ativityComponent).build().inject(this)
        mPresenter.mView = this
    }

    override fun registerResult(result: UserInfo) {
        if (result != null) {
            Toast.makeText(this, "注册成功", Toast.LENGTH_LONG).show()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        registerBtn.onClick {
            mPresenter.register(
                mobile.text.toString(),
                vertifyCode.text.toString(),
                password.text.toString()
            )
        }
    }

    override fun onBackPressed() {
        var time = System.currentTimeMillis()
        if (time - pressTime > 2000) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_LONG).show()
            pressTime = time
        } else {
            AppManager.instant.exitApp(this)
        }
    }

}
