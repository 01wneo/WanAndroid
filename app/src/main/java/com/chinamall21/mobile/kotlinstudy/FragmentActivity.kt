package com.chinamall21.mobile.kotlinstudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.chinamall21.mobile.kotlinstudy.fragment.FragmentA


/**
 * desc：
 * author：Created by xusong on 2019/3/1 16:06.
 */

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.fl_container,FragmentA()).commitAllowingStateLoss()
    }

}


