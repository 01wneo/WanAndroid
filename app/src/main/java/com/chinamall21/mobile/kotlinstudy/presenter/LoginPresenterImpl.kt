package com.chinamall21.mobile.kotlinstudy.presenter

import com.chinamall21.mobile.kotlinstudy.bean.LoginResponse
import com.chinamall21.mobile.kotlinstudy.bean.RegisterResponse
import com.chinamall21.mobile.kotlinstudy.model.LoginModel
import com.chinamall21.mobile.kotlinstudy.model.LoginModelImpl
import com.chinamall21.mobile.kotlinstudy.view.LoginView
/**
 * desc：
 * author：Created by xusong on 2019/2/28 16:25.
 */
class LoginPresenterImpl(val loginview:LoginView):LoginPresenter,LoginPresenter.onLoginListener,LoginPresenter.onRegisterListener{

    val mLoginModel:LoginModel

    init {
        mLoginModel = LoginModelImpl()
    }

    override fun login(username: String, password: String) {
        mLoginModel.login(this,username, password)
    }

    override fun loginSuccess(result: LoginResponse) {
        loginview.loginSuccess(result)
    }

    override fun loginFailed(message: String?) {
        loginview.loginFailed(message)
    }

    override fun register(username: String, password: String, email: String) {
        mLoginModel.register(this,username, password, email)
    }

    override fun registerSuccess(result: RegisterResponse) {
        loginview.registerSuccess(result)
    }

    override fun registerFailed(message: String?) {
        loginview.registerFailed(message)
    }
}