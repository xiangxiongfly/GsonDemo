package com.example.lib_java.test

import com.google.gson.Gson

data class UserBean(val name: String, val age: Int)

val json2 = """
        {
            "name":null,
            "age":null
        }
    """.trimIndent()

fun main() {
    val userBean = Gson().fromJson(json2, UserBean::class.java)
    println(userBean)
    printMsg(userBean.name)
}

fun printMsg(msg: String) {
}