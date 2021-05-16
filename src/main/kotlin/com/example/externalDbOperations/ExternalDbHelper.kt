package com.example.externalDbOperations

import com.example.OnResultListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import tornadofx.launch
import tornadofx.runAsync
import tornadofx.runLater
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

abstract class ExternalDbHelper : Thread() {

    lateinit var onResultListener: OnResultListener

    companion object {
        const val BASE_URL = "http://sobos.ssd-linuxpl.com/"
    }

    fun setConnection(address: String?): HttpURLConnection {
        lateinit var conn: HttpURLConnection
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

    fun setOnResultListener(operation: (String) -> Unit) {
        onResultListener = object : OnResultListener {
            override fun onReceive(result: String) {
                runLater {   operation(result)}
            }
        }
    }
}