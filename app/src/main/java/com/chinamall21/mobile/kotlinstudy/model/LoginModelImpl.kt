package com.chinamall21.mobile.kotlinstudy.model

import com.chinamall21.mobile.kotlinstudy.presenter.LoginPresenter
import com.chinamall21.mobile.kotlinstudy.utils.RetrofitUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * desc：
 * author：Created by xusong on 2019/2/28 17:06.
 */

class LoginModelImpl :LoginModel {

    var mOnLoginListener :LoginPresenter.onLoginListener? = null

    var mOnRegisterListener :LoginPresenter.onRegisterListener? = null

    override fun login(onLoginListener: LoginPresenter.onLoginListener, username: String, password: String) {
        if(mOnLoginListener==null){
            mOnLoginListener = onLoginListener
        }
        RetrofitUtils
                .retrofitService
                .userLogin(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (
                        {
                            result ->

                            when (result.retCode) {
                                "200" ->
                                    mOnLoginListener?.loginSuccess(result)
                                else ->
                                    mOnLoginListener?.loginFailed(result.msg)
                            }
                        },
                        {
                            error ->
                            mOnLoginListener?.loginFailed(error.message)
                        }
                )

    }

    override fun register(onRegisterListener: LoginPresenter.onRegisterListener, username: String, password: String, email: String) {
        if(mOnRegisterListener==null){
            mOnRegisterListener =onRegisterListener
        }
        RetrofitUtils
                .retrofitService
                .userRegister(username, password, email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            result ->
                            when (result.retCode) {
                                "200" ->
                                    mOnRegisterListener?.registerSuccess(result)
                                else ->
                                    mOnRegisterListener?.registerFailed(result.msg)
                            }
                        },
                        {
                            error ->
                            mOnRegisterListener?.registerFailed(error.message)
                        }
                )
    }

}