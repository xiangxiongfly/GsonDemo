package com.example.lib_java.test

import com.google.gson.Gson

data class UserBean(val name: String = "未知", val age: Int)

val json2 = """
        {
        
        }
    """.trimIndent()

fun main() {
    val userBean = Gson().fromJson(json2, UserBean::class.java)
    println("姓名：${userBean.name} 年龄：${userBean.age}")
}

//姓名：null 年龄：0