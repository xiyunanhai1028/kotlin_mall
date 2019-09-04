package com.kotlin.usercenter.ui.activity

import android.os.Bundle
import com.kotlin.baselibrary.ext.enable
import com.kotlin.baselibrary.ext.onClick
import com.kotlin.baselibrary.ui.activity.BaseMvpActivity
import com.kotlin.usercenter.R
import com.kotlin.usercenter.injection.component.DaggerUserComponent
import com.kotlin.usercenter.presenter.LoginPresenter
import com.kotlin.usercenter.presenter.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast

/**
 *    author : dufeihu
 *    date   : 2019/9/3 19:11
 *    desc   :登录
 */
class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginView {

    override fun loginResult(tokenId: String) {
        if (tokenId.isNullOrEmpty().not()) {
            toast("登录成功")
        }
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(ativityComponent).build().inject(this)
        mPresenter.mView = this
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val bundle = intent.getBundleExtra("bundle")
        val tattedId = bundle.getString("tattedId")
        val mobile = bundle.getString("mobile")

        mobileTv.text = mobile

        loginBtn.enable(code) { isBtnEnable() }

        loginBtn.onClick{
            mPresenter.login(mobile, tattedId, code.text.toString())
        }
    }

    private fun isBtnEnable(): Boolean {
        return mobileTv.text.isNullOrEmpty().not()
    }
}