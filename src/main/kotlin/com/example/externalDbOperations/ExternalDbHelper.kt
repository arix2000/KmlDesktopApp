package com.example.externalDbOperations

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

abstract class ExternalDbHelper : Thread() {

    companion object {
        const val IO_EXCEPTION_TAG = "IO_EXCEPTION_TAG"
        const val BASE_URL = "http://sobos.ssd-linuxpl.com/"
    }

    fun setConnection(address: String?): HttpURLConnection? {
        var conn: HttpURLConnection? = null
        try {
            val url = URL(address)
            conn = url.openConnection() as HttpURLConnection
            conn.doOutput = true
            conn.doInput = true
            conn.requestMethod = "POST"
        } catch (e: IOException) {
            println("IOException setConnection: " + e.message)
        }
        return conn
    }

    fun readResult(conn: HttpURLConnection): String {
        val inputStream: InputStream
        val readResult = StringBuilder()
        try {
            inputStream = conn.inputStream
            val reader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                readResult.append(line)
            }
            inputStream.close()
            reader.close()
            conn.disconnect()
        } catch (e: IOException) {
            println("readResult: " + e.message)
        }
        return readResult.toString()
    }
}