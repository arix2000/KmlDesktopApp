package com.example.controllers

import com.example.GlobalVars
import com.example.externalDbOperations.DbChangePass

class PasswordChangerController {

    fun isSuite(newPass:String, oldPass:String): Boolean
    {
        return !(newPass.trim().isEmpty() or oldPass.trim().isEmpty())
    }

    fun sendFormForResult(newPass:String, oldPass:String): String
    {
        val dbChangePass = DbChangePass(newPass, oldPass, GlobalVars.loginId)
        dbChangePass.start()

        return dbChangePass.result
    }
}