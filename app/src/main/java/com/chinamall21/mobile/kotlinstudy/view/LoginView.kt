package com.chinamall21.mobile.kotlinstudy.view

import com.chinamall21.mobile.kotlinstudy.bean.LoginResponse
import com.chinamall21.mobile.kotlinstudy.bean.RegisterResponse


/**
 * desc：
 * author：Created by xusong on 2019/2/28 16:09.
 */

interface LoginView {

    fun loginSuccess(result:LoginResponse)

    fun loginFailed(message:String?)

    fun registerSuccess(result:RegisterResponse)

    fun registerFailed(message: String?)
}