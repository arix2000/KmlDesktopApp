package com.example.controllers

import com.example.app.GlobalVars
import com.example.app.Strings
import com.example.externalDbOperations.DbLogin
import java.io.File
import java.net.URLEncoder
import java.nio.file.Files
import java.nio.file.LinkOption
import java.util.*

class LoginController {

    fun logIn(login: String, password: String): Boolean {
        val dbLogin = DbLogin(login, password)
        dbLogin.start()

        return if (dbLogin.result.contains("true")) {
            GlobalVars.loginId = dbLogin.result.substringAfter("true").trim().toInt()
            saveLogData(login, password)
            true
        } else false

    }

    private fun saveLogData(login: String, password: String) {
        val file = File(Strings.LOG_DATA)
        val encodedString: String = Base64.getEncoder().encodeToString("$login;$password".toByteArray())
        file.writeText(encodedString)
    }

    fun getLogData(): String {
        val file = File(Strings.LOG_DATA)
        return if (file.exists()) {
            String(Base64.getDecoder().decode(file.readText()))
        } else ""
    }
}