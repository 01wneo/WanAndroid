package com.chinamall21.mobile.kotlinstudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //methodTest()
        //varibleTest()
        //doTest()
        //nullTest("12","4")
        //println(getStringLength(""))
        //loopTest()
        //rangeTest()
        //listTest()
        //var customer = Customer("xw","230.com")
        //var list = arrayOf("r","p","q","e")
        //main(list)
        // var address = Address()

        //Kotlin 的属性
//        val user = User("wa", "de")
//        user.fullName = "nam.w"
//        println(user.last + user.first)
//        var person = Person()
//        println(person.name)
//        person.name = "aaa"
//        println(person.name)
//        basicTypeTest()
//        arrayTest()
//        IdomTest()
        D6(5)

    }

    private fun D6(a: Any) {
        when (a) {
            in 1..10-> println("1-10")
            is String -> println("str")
            1,2,3,4 -> println("one-four")
            else -> {
                println("none")
            }

        }
//        loop@ for (i in 1..100){ // loop@就是标签
//           println(i)
//        }

        loop@ for(i in 1..10){
            for(j in 1..100){
                println(j)
                if(j==5){
                    break
                }
            }
        }


    }

    private fun IdomTest() {
        val map = mapOf("a" to 1, "b" to 2, "c" to 3)
        println(map.toString())
        println(map.get("a"))
        println(map["a"])

        toast("hahah安徽")

        var resource = Resource
        val files = File("Test").listFiles()
        // 对files加了不为空的判断(?)
        println(files?.size)

        val file = File("Test").listFiles()
        println(file?.size ?: "empty")

        val a = "qq"
        //let{}不为空的时候执行
        println(a ?: "weinull")
        println(a?.let {
            "aaaaaaaa"
        })

    }

    fun toast(cotent: String) {
        Toast.makeText(this, cotent, Toast.LENGTH_SHORT).show()
    }

    //单例
    object Resource {
        val name = "Name"
    }

    private fun arrayTest() {
        var arr1 = arrayOf("1", "2", "3")
        println(arr1.size)
        val asc = Array(5, { i -> (i * i).toString() })
    }

    private fun basicTypeTest() {
        val oneMillion = 1_000_00
        val hexBytes = 0xFF_EC_DE_5E
        val bytes = 0b11010010_01101001_10010100_10010010

        val a: Int = 1000
        println(a === a)
        val b: Int? = a
        val c: Int? = a
        println(b == c)
//短类型是不会隐式(自动)转换为长类型的，需要显示(手动)转换才行
//        toByte(): Byte
//        toShort(): Short
//        toInt(): Int
//        toLong(): Long
//        toFloat(): Float
//        toDouble(): Double
//        toChar(): Char
        val d: Byte = 1
        val e: Int = d.toInt()

        val l = 1.toLong() + 1 // Long  + Int => Long，自动转换成Long类型
        println(digtalValue('6'))
    }

    fun digtalValue(c: Char): Int {
        if (c !in '0'..'9') {
            throw IllegalArgumentException("Out of range")
        }
        return c.toInt() - '0'.toInt()
    }

    class User(first: String, last: String) {
        var first: String = first
        var last: String = last
        var fullName
            get() = "${first}.${last}"
            set(value) {
                println("执行fullname 的 setter 方法")
                if ("." !in value || value.indexOf(".") != value.lastIndexOf(".")) {
                    println("你输入的fullName 不合法")
                } else {
                    var token = value.split(".")
                    first = token[0]
                    last = token[1]
                }
            }
    }

    class Person {
        var name: String = "shenzhen"
            get() = field
            set(value) {
                field = "name $field"
            }
    }

    fun main(args: Array<String>) {
        if (args.size == 0) return
        println("first arguments ${args[0]}")
    }

    data class Customer(var name: String, var emil: String)

    private fun listTest() {
        val items = listOf("apple", "pear", "melon")
        for (item in items) {
            println(item)
        }
        when {//匹配到就return
            "appl1e" in items -> println("juicy")
            "pear" in items -> println("pearr")
        }
        items.filter { it.startsWith("a") }
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach { println(it) }
    }

    private fun rangeTest() {
        val x = 10
        val y = 9
        if (x in 1..100) {
            println("fits in Range")
        } else {
            println("out of Range")
        }
        //检测某个数字是否在区间外
        val list = listOf<String>("a", "b", "c")
        println(list.size)
        if (-1 !in 0..list.lastIndex) {
            println("-1 is out of range")
        }
        if (list.size !in list.indices) {
            println("list.size is out if list.indices")
        }
        //区间迭代
        for (x in 1..5) {
            println(x)
        }
        //数列迭代
        for (x in 1..10 step 4) {
            println("x=" + x)
        }
        for (x in 10 downTo 0 step 3) {
            println("x==" + x)
        }

    }

    private fun loopTest() {
        var items = listOf<String>("Apple", "Banana", "pear")
        //for 循环
        for (item in items) {
            println(item)
        }
        for (item in items.indices) {
            println("item at $item is ${items[item]}")
        }
        //while循环
        var index = 0
        while (index < items.size) {
            println("item in $index is ${items[index]}")
            index++
        }
        //when表达式
        println(describe(100L))
    }

    fun describe(obj: Any): String =
            when (obj) {
                1 -> "One"
                is String -> "String"
                is Long -> "Long"
                !is String -> "not String"
                else -> "unknow"
            }

    private fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            return obj.length
        }
        return null

    }

    private fun nullTest(str1: String, str2: String) {
        var a = parseInt(str1)
        var b = parseInt(str2)
        if (a != null && b != null) {
            println(a * b)
        } else {
            println("a or b is not a number")
        }

    }

    fun parseInt(str: String): Int? {
        return str.toIntOrNull()
    }

    private fun doTest() {
        println(getMax(10, 100))
        println(maxOf(100, 1000))
        println("max of 100 and 1000 ${getMax(100, 1000)}")
        println("max of 100 and 1000 ${maxOf(100, 1000)}")
    }

    fun getMax(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    fun MaxOf(a: Int, b: Int) = if (a > b) a else b

    private fun varibleTest() {
        val a: Int = 1
        val b = 2
        val c: Int
        var d = 1
        val s = "d is $d"
        d = 2
        val s1 = "${s.replace("is", "was")},but now is $d"
        println(s1)

    }

    private fun methodTest() {
        println(sum(5, 3))
        println(sum1(5, 9))
        printSum(10, 20)
        printSum1(100, 200)
    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    //将表达式作为函数体、返回值类型自动推断的函数：
    fun sum1(a: Int, b: Int) = a + b

    //函数返回无意义的值
    fun printSum(x: Int, y: Int): Unit {
        println("sum of $x and $y is ${x + y}")
    }

    //函数返回无意义的值
    fun printSum1(x: Int, y: Int) {
        println("sum of $x and $y is ${x + y}")
    }

}
