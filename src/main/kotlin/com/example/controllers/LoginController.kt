package com.example.controllers

import com.example.OnResultListener
import com.example.app.GlobalVars
import com.example.app.Strings
import com.example.externalDbOperations.DbLogin
import tornadofx.runLater
import java.io.File
import java.util.*

class LoginController {

    lateinit var onResultListener: OnResultListener

    fun logIn(login: String, password: String) {
        val dbLogin = DbLogin(login, password)
        dbLogin.start()
        dbLogin.setOnResultListener {
            val result = if (it.contains("true")) {
                GlobalVars.loginId = it.substringAfter("true").trim().toInt()
                saveLogData(login, password)
                "true"
            } else "false"

            onResultListener.onReceive(result)
        }
    }

    fun saveLogData(login: String, password: String) {
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

    fun setOnResultListener(operation: (Boolean) -> Unit) {
        onResultListener = object : OnResultListener {
            override fun onReceive(result: String) {
                operation(result.toBoolean())
            }
        }
    }
}