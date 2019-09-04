package com.kotlin.usercenter.ui.activity

import android.os.Bundle
import android.widget.Toast
import com.kotlin.baselibrary.common.AppManager
import com.kotlin.baselibrary.ext.enable
import com.kotlin.baselibrary.ext.onClick
import com.kotlin.baselibrary.ui.activity.BaseMvpActivity
import com.kotlin.usercenter.R
import com.kotlin.usercenter.injection.component.DaggerUserComponent
import com.kotlin.usercenter.presenter.RegisterPresenter
import com.kotlin.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.startActivity

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {

    private var pressTime: Long = 0
    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(ativityComponent).build().inject(this)
        mPresenter.mView = this
    }

    override fun registerResult(result: String) {
        if (!result.isNullOrEmpty()) {
            var bundle = Bundle()
            bundle.putString("tattedId", result)
            bundle.putString("mobile", mobileTv.text.toString())
            startActivity<LoginActivity>("bundle" to bundle)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initView()
    }

    private fun initView() {
        nextStep.enable(mobileTv) { isBtnEnable() }

        nextStep.onClick {
            mPresenter.register(mobileTv.text.toString())
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

    private fun isBtnEnable(): Boolean {
        return mobileTv.text.isNullOrEmpty().not()
    }
}
