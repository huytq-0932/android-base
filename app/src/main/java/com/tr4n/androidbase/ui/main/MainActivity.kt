package com.tr4n.androidbase.ui.main

import com.tr4n.androidbase.R
import com.tr4n.androidbase.ui.home.HomeFragment
import com.tr4n.base.view.mvp.BaseActivity

class MainActivity : BaseActivity(), MainContract.View {

    override val layoutResource: Int get() = R.layout.activity_main

    private val presenter by lazyOf(MainPresenter())

    override fun initComponent() {
        openFragment(R.id.frameContent, HomeFragment.newInstance(), false)
    }

    override fun initData() {
    }

    override fun showToast(msg: String) {
    }
}
