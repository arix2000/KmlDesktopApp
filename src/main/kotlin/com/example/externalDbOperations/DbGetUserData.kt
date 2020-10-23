package com.example.externalDbOperations

import com.example.GlobalVars
import java.io.BufferedWriter
import java.io.IOException
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URLEncoder

class DbGetUserData : ExternalDbHelper() {
    private val fileName = "getDataAboutUser.php"
    var result: String = ""
        get() {
            this.join()
            return field
        }


    override fun run() {
        val address = BASE_URL + fileName
        try {
            val connection = setConnection(address)
            sendData(connection)
            result = readResult(connection!!)
        } catch (e: Exception) {
            println("run: " + e.message)
        }
    }

    @Throws(IOException::class)
    private fun sendData(connection: HttpURLConnection?) {
        val outStream = connection!!.outputStream
        val writer = BufferedWriter(OutputStreamWriter(outStream, "UTF-8"))
        val dataToSend =
            URLEncoder.encode("loginId", "UTF-8") + "=" + URLEncoder.encode(GlobalVars.loginId.toString(), "UTF-8")
        writer.write(dataToSend)
        writer.flush()
        writer.close()
        outStream.close()
    }

}