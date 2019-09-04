package com.kotlin.baselibrary.ui.activity

import android.os.Bundle
import android.widget.Toast
import com.kotlin.baselibrary.common.BaseApplication
import com.kotlin.baselibrary.injection.component.ActivityComponent
import com.kotlin.baselibrary.injection.component.DaggerActivityComponent
import com.kotlin.baselibrary.injection.module.ActivityModule
import com.kotlin.baselibrary.injection.module.LifecycleProvideModule
import com.kotlin.baselibrary.presenter.BasePresenter
import com.kotlin.baselibrary.presenter.view.BaseView
import com.kotlin.baselibrary.widget.ProgressDialog
import javax.inject.Inject

/**
 *    author : dufeihu
 *    date   : 2019/8/23 12:47
 *    desc   :
 */
open abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {
    @Inject
    lateinit var mPresenter: T

    lateinit var ativityComponent: ActivityComponent

    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()
        progressDialog = ProgressDialog.create(this)
    }

    abstract fun injectComponent()

    private fun initActivityInjection() {
        ativityComponent = DaggerActivityComponent.builder()
            .appComponent((application as BaseApplication).appComponent)
            .activityModule(ActivityModule(this))
            .lifecycleProvideModule(LifecycleProvideModule(this))
            .build()
    }

    override fun showLoading() {
        progressDialog.showLoading()
    }

    override fun hideLoading() {
        progressDialog.cancelLoading()
    }

    override fun onError(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

}