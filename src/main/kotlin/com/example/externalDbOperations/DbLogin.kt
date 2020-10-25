package com.example.externalDbOperations

import java.io.BufferedWriter
import java.io.IOException
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URLEncoder

class DbLogin(login: String, password: String) : ExternalDbHelper() {
    private val fileName = "login.php"
    private lateinit var httpConnection: HttpURLConnection
    var result: String = ""
    get() { this.join(); return field}
    private val address: String
    private val login: String
    private val password: String


    override fun run() {
        httpConnection = setConnection(address)
        sendData()
        result = readResult(httpConnection)
    }

    private fun sendData() {
        try {
            val outStream = httpConnection.outputStream
            val writer = BufferedWriter(OutputStreamWriter(outStream, "UTF-8"))
            val dataToSend = (URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(login, "UTF-8")
                    + "&&" + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8"))
            writer.write(dataToSend)
            writer.flush()
            writer.close()
        } catch (e: IOException) {
            println("sendData: " + e.message)
        }
    }

    init {
        address = BASE_URL + fileName
        this.login = login
        this.password = password
    }
}