package com.example.externalDbOperations

import java.io.BufferedWriter
import java.io.IOException
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URLEncoder

class DbLogin(val login: String, val password: String) : ExternalDbHelper() {
    private val fileName = "login.php"
    private lateinit var httpConnection: HttpURLConnection
    private var result: String = ""
       // get() { this.join(); return field }
    private val address: String = BASE_URL + fileName


    override fun run() {
        sleep(2000)
        httpConnection = setConnection(address)
        sendData()
        result = readResult(httpConnection)
        onResultListener.onReceive(result)
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
}