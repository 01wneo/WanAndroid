package com.chinamall21.mobile.kotlinstudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import cn.pedant.SweetAlert.SweetAlertDialog
import com.chinamall21.mobile.kotlinstudy.bean.LoginResponse
import com.chinamall21.mobile.kotlinstudy.bean.RegisterResponse
import com.chinamall21.mobile.kotlinstudy.presenter.LoginPresenter
import com.chinamall21.mobile.kotlinstudy.presenter.LoginPresenterImpl
import com.chinamall21.mobile.kotlinstudy.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import java.util.regex.Pattern


/**
 * desc：
 * author：Created by xusong on 2019/2/28 12:12.
 */

class LoginActivity : AppCompatActivity(), View.OnClickListener ,LoginView{

    var dialog:SweetAlertDialog? = null
    var mPresenter:LoginPresenter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        bt_register.setOnClickListener(this)
        bt_login.setOnClickListener(this)
        mPresenter = LoginPresenterImpl(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.bt_register -> {
                if(checkInput(true)){

                }


            }

            R.id.bt_login -> {
                if(checkInput(false)){
                    mPresenter?.login(et_username.text.toString(),et_pwd.text.toString())
                }

            }
        }
    }

    fun checkInput(register:Boolean): Boolean {
        if (TextUtils.isEmpty(et_username.text.toString())) {
            et_username.error = "用户名不能为空"
            return false
        }
        if (TextUtils.isEmpty(et_pwd.text.toString())) {
            et_pwd.error = "密码不能为空"
            return false
        }
        if ((et_pwd.text.toString().length<6)) {
            et_pwd.error = "密码不能小于6位"
            return false
        }
        if(register){
            val regex = "\\w+(\\.\\w)*@\\w+(\\.\\w{2,3}){1,3}"
            val pattern = Pattern.compile(regex)
            if(!pattern.matcher(et_email.text.toString()).matches()){
                et_email.error = "邮箱格式不正确"
                return false
            }
        }
        return true
    }

    override fun loginSuccess(result: LoginResponse) {
        println("loginSuccess")
    }

    override fun loginFailed(message: String?) {
        println("loginFailed"+message)
    }

    override fun registerSuccess(result: RegisterResponse) {
        println("registerSuccess"+result.msg)
    }

    override fun registerFailed(message: String?) {
        println("registerFailed"+message)
    }


}