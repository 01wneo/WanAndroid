package com.chinamall21.mobile.kotlinstudy.model

import com.chinamall21.mobile.kotlinstudy.presenter.LoginPresenter


/**
 * desc：
 * author：Created by xusong on 2019/2/28 16:52.
 */

interface LoginModel {
    /**
     * 登录
     */
    fun login(onLoginListener: LoginPresenter.onLoginListener, username: String, password: String)

    /**
     * 注册
     */
    fun register(onRegisterListener: LoginPresenter.onRegisterListener, username: String, password: String,email:String)

}