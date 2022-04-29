package com.example.lib_java.test

import com.google.gson.Gson

data class UserBean(val name: String = "未知", val age: Int = -1)

fun main() {

    val json2 = """
        {
           "name":null,
           "age":null
        }
    """.trimIndent()

    val userBean2 = Gson().fromJson<UserBean>(json2, UserBean::class.java)
    println("${userBean2.name} ${userBean2.age}")


//    printMsg(userBean2.name) //抛出异常
//    userBean2.name?.let {
//        printMsg(it)
//    }


}

fun printMsg(msg: String) {

}


/*
//    val json1 = """
//        {
//            "name":"小明",
//            "age":18
//        }
//    """.trimIndent()

//    val userBean = Gson().fromJson<UserBean>(json1, UserBean::class.java)
//    println("${userBean.name} ${userBean.age}")
//    printMsg(userBean.name)
 */