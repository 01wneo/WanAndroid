package com.chinamall21.mobile.kotlinstudy.fragment

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.chinamall21.mobile.kotlinstudy.R.color.green
import com.chinamall21.mobile.kotlinstudy.R.layout.fragment_a
import com.chinamall21.mobile.kotlinstudy.adapter.TestAdapter
import com.chinamall21.mobile.kotlinstudy.bean.TestBean
import kotlinx.android.synthetic.main.fragment_a.*


/**
 * desc：
 * author：Created by xusong on 2019/3/1 16:13.
 */

class FragmentA : Fragment(), SwipeRefreshLayout.OnRefreshListener {

    var mList :ArrayList<TestBean>?= null
    var mAdapter:TestAdapter?=null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutInflater.inflate(fragment_a, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //当只需要一个对象,没有父类的情况下
        val adHoc = object {
            var x: Int = 0
            var y: Int = 0
        }
        Constant.url
        Constant.data
        Constant.type

        mList= arrayListOf<TestBean>()
        for (i in 1..100) {
            var bean: TestBean
            if (i % 3 == 0) {
                bean = TestBean(1, "我是Type" + i)
            } else {
                bean = TestBean(0, "我是数据" + i)
            }

            mList!!.add(bean)
        }
        mAdapter = TestAdapter(mList!!)
        rv.layoutManager = LinearLayoutManager(activity)
        rv.adapter = mAdapter
        refresh.setColorSchemeColors(resources.getColor(green))
        refresh.setOnRefreshListener(this)

    }

    override fun onRefresh() {
        Handler().postDelayed(Runnable {
            Toast.makeText(activity, "Refresh Finish", Toast.LENGTH_SHORT).show()
            mList!!.add(0,TestBean(0,"下拉刷新出来的数据"))
            mAdapter!!.setNewData(mList!!)
            refresh.isRefreshing = false
        }, 1500)
    }

    class Student(val fistName: String, val lastName: String, var age: Int) {}

    //二级构造函数
    class Person(val name: String) {
        constructor(name: String, paret: Person) : this(name) {}
        constructor(name: String, parent: Person, count: Int) : this(name) {}
    }

    //继承
    open class Base(p: Int)

    class Derived(p: Int) : Base(p)

    /**
     * 父类
     */
    open class BaseKot(name: String) {
        open val age: Int get() = 0
        open fun test() {

        }
    }

    class Kot : BaseKot {
        override var age: Int = super.age + 1

        constructor(name: String) : super(name) {}

        override fun test() {
            super.test()
        }
    }

    open class A {
        open fun f() {
            print("A")
        }

        fun a() {
            print("a")
        } // 不会被重写
    }

    interface B {
        fun f() {
            print("B")
        } // 接口成员默认是open的

        fun b() {
            print("b")
        }
    }

    class C() : A(), B {
        // The compiler requires f() to be overridden:
        override fun f() {
            super<A>.f() // call to A.f()
            super<B>.f() // call to B.f()
        }
    }

    enum class Direction {
        NORTH, SOUTH, WEST, EAST
    }

    enum class Color(val rgb: Int) {
        RED(0xFF0000),
        GREEN(0x00FF00),
        BLUE(0x0000FF)
    }

    //将常量统一写到一个类里面，然后设置静态变量，
    // 由于在Kotlin中不存在静态变量，所有就有对象声明的存在，
    // 对象声明比较常用的地方就是在这里，对象声明用Objcet关键字表示。
    object Constant {
        var url = "www.baidu.com"
        var data = 1
        val type = "3"

    }

    //单例
    class SingletonDemo private constructor() {
        companion object {
            val instance: SingletonDemo by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
                SingletonDemo()
            }
        }
    }

    //泛型
    class Box<T>(t: T) {
        var value = t
    }

    //使用
    val box = Box("string")


    abstract class Source<out T> {
        // 使用out的话，T只能作为返回值
        abstract fun nextT(): T
        // 不能作为传入参数，下面会报错
        // abstract fun add(value: T)
    }

    fun demo(strs: Source<String>) {
        val objects: Source<Any> = strs
    }


}