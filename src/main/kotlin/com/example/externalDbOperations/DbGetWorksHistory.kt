package com.example.externalDbOperations

import com.example.app.GlobalVars
import java.io.BufferedWriter
import java.io.IOException
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URLEncoder

class DbGetWorksHistory : ExternalDbHelper() {

    private val fileName = "getWorkHistory.php"
    private val address: String
    var result: String = ""
        get() {join(); return field}
    private lateinit var conn: HttpURLConnection
    override fun run() {
        conn = setConnection(address)
        sendData()
        result = readResult(conn)
    }

    private fun sendData() {
        try {
            val outStream = conn.outputStream
            val writer = BufferedWriter(OutputStreamWriter(outStream, "UTF-8"))
            val dataToSend =
                (URLEncoder.encode("firstName", "UTF-8") + "=" + URLEncoder.encode(GlobalVars.firstName, "UTF-8")
                        + "&&" + URLEncoder.encode("lastName", "UTF-8") + "=" + URLEncoder.encode(
                    GlobalVars.lastName,
                    "UTF-8"
                ))
            writer.write(dataToSend)

            writer.flush()
            writer.close()
            outStream.close()
        } catch (e: IOException) {
            println("sendData: " + e.message)
        }
    }

    init {
        address = BASE_URL + fileName
    }
}