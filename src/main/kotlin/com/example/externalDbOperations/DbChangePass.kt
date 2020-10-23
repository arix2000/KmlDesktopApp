package com.example.externalDbOperations

import java.io.BufferedWriter
import java.io.IOException
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URLEncoder

class DbChangePass(private val newPassword: String, private val oldPassword: String, private val loginId: Int) :
    ExternalDbHelper() {
    private val fileName = "changePass.php"
    private lateinit var internalResult: String

    var result: String = ""
        get() {
            this.join()
            return field
        }

    override fun run() {
        val address = BASE_URL + fileName

        try {
            val conn = setConnection(address)
            sendData(conn)
            internalResult = readResult(conn)

            result = when (internalResult) {
                "1" -> "Zmieniono hasło pomyślnie"
                "0" -> "Coś poszło nie tak! Sprawdź połączenie z internetem lub spróbuj ponownie później."
                else -> internalResult
            }

        } catch (e: IOException) {
            println("run: " + e.message)
        }
    }

    @Throws(IOException::class)
    private fun sendData(conn: HttpURLConnection) {
        val outSteam = conn.outputStream
        val writer = BufferedWriter(OutputStreamWriter(outSteam, "UTF-8"))
        val dataToSend = (URLEncoder.encode("newPassword", "UTF-8") + "=" + URLEncoder.encode(
            newPassword, "UTF-8"
        )
                + "&&" + URLEncoder.encode("oldPassword", "UTF-8") + "=" + URLEncoder.encode(oldPassword, "UTF-8")
                + "&&" + URLEncoder.encode("loginId", "UTF-8") + "=" + URLEncoder.encode(loginId.toString(), "UTF-8"))
        writer.write(dataToSend)
        writer.flush()
        writer.close()
        outSteam.close()
    }
}