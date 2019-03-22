package com.chinamall21.mobile.kotlinstudy.presenter

import com.chinamall21.mobile.kotlinstudy.bean.LoginResponse
import com.chinamall21.mobile.kotlinstudy.bean.RegisterResponse


/**
 * desc：
 * author：Created by xusong on 2019/2/28 14:56.
 */

interface LoginPresenter {

    fun login(username: String, password: String)

    interface onLoginListener {

        fun loginSuccess(result: LoginResponse)

        fun loginFailed(message: String?)

    }

    fun register(username: String, password: String, email: String)

    interface onRegisterListener {
        fun registerSuccess(result: RegisterResponse)

        fun registerFailed(message: String?)
    }
}