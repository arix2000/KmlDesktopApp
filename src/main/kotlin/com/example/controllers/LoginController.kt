package com.example.controllers

import com.example.app.GlobalVars
import com.example.externalDbOperations.DbLogin

class LoginController {

    fun logIn(login: String, password: String): Boolean {
        val dbLogin = DbLogin(login, password)
        dbLogin.start()

        return if(dbLogin.result.contains("true")) {
            GlobalVars.loginId = dbLogin.result.substringAfter("true").trim().toInt()
            true
        } else false

    }
}